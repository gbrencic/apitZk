package zk_old.stage;

/**
 * User: gbrencic
 * Date: 22.03.12.
 * Time: 10:14
 */
public class MapDimensions {
    private final int x;
    private final int y;
    private final int z;

    public MapDimensions(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
