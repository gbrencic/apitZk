package pleasantnightmare.game.inventory;

/**
 * User: gbrencic
 * Date: 03.09.12.
 * Time: 13:09
 */
public interface InventoryItem {
    Size getSize();

    boolean smallerThan(Size size);

    int getSurfaceSize();
}
