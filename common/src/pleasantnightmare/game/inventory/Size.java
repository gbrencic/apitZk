package pleasantnightmare.game.inventory;

/**
 * User: gbrencic
 * Date: 03.09.12.
 * Time: 13:15
 */
public class Size {
    private final int sizeX;
    private final int sizeY;
    private int surfaceSize;

    public Size(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.surfaceSize = sizeX * sizeY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public boolean smallerThan(Size size) {
        return sizeX <= size.getSizeX() && sizeY <= size.getSizeY();
    }

    public boolean surfaceLargerThan(int surfaceSize) {
        return this.surfaceSize >= surfaceSize;
    }

    public int getSurfaceSize() {
        return surfaceSize;
    }

    public static Size tinySquare() {
        return new Size(1, 1);
    }

    public static Size smallSquare() {
        return new Size(2, 2);
    }

    public static Size mediumSquare() {
        return new Size(4, 4);
    }

    public static Size largeSquare() {
        return new Size(8, 8);
    }

    public static Size hugeSquare() {
        return new Size(16, 16);
    }
}
