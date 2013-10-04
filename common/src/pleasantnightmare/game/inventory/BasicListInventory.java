package pleasantnightmare.game.inventory;

import java.util.LinkedList;
import java.util.List;

/**
 * User: gbrencic
 * Date: 03.09.12.
 * Time: 13:06
 */
public class BasicListInventory {
    private final Size size;
    private int itemsSurfaceSize = 0;
    private List<InventoryItem> items = new LinkedList<InventoryItem>();

    public BasicListInventory(Size size) {
        this.size = size;
    }

    public void put(InventoryItem item) throws InventoryException {
        if (!canHoldItem(item))
            throw new InventoryException("Cannot hold item!");
        this.items.add(item);
        this.itemsSurfaceSize += item.getSurfaceSize();
    }

    public boolean canHoldItem(InventoryItem item) {
        return item.smallerThan(size) && size.surfaceLargerThan(getItemsSurfaceSize() + item.getSurfaceSize());
    }

    public int getItemsSurfaceSize() {
        return itemsSurfaceSize;
    }

    public void empty() {
        items.clear();
        itemsSurfaceSize = 0;
    }

    public int getItemCount() {
        return items.size();
    }

    public boolean contains(InventoryItem item) {
        return items.contains(item);
    }
}
