package pleasantnightmare.game.inventory;

/**
 * User: gbrencic
 * Date: 03.09.12.
 * Time: 13:10
 */
public class BasicInventoryItem implements InventoryItem {
    private final Size size;

    public BasicInventoryItem(Size size) {
        this.size = size;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public boolean smallerThan(Size size) {
        return this.size.smallerThan(size);
    }

    @Override
    public int getSurfaceSize() {
        return size.getSurfaceSize();
    }
}
