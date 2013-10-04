package hr.pleasantnightmare.game.inventory;

import pleasantnightmare.game.inventory.*;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * User: gbrencic
 * Date: 03.09.12.
 * Time: 13:06
 */
public class BasicListInventoryTest {
    public BasicListInventoryTest() {
        BasicListInventory inventory = new BasicListInventory(Size.mediumSquare());
        InventoryItem item = new BasicInventoryItem(new Size(1, 1));

        //Small item is ok
        assertTrue(inventory.canHoldItem(item));
        inventory.put(item);
        assertTrue(inventory.contains(item));
        inventory.empty();

        //Item too big
        item = new BasicInventoryItem(Size.hugeSquare());
        assertFalse(inventory.canHoldItem(item));
        try {
            inventory.put(item);
        } catch (InventoryException e) {
            System.out.println("COMMENT: " + e.getMessage());
        }
        assertFalse(inventory.contains(item));

        //ManyItems
        inventory.put(new BasicInventoryItem(Size.tinySquare()));
        inventory.put(new BasicInventoryItem(Size.tinySquare()));
        assertEquals(2, inventory.getItemCount());
        inventory.empty();

        //ManyItems No more room
        inventory.put(new BasicInventoryItem(Size.mediumSquare()));
        try {
            inventory.put(new BasicInventoryItem(Size.tinySquare()));
        } catch (InventoryException e) {
            System.out.println("COMMENT: " + e.getMessage());
        }
        assertEquals(1, inventory.getItemCount());

    }

    public static void main(String[] args) {
        new BasicListInventoryTest();
    }
}
