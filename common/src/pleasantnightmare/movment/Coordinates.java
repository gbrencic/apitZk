package pleasantnightmare.movment;

/**
 * User: gbrencic
 * Date: 05.03.12.
 * Time: 14:02
 */
public class Coordinates {
    private int x = 0;
    private int y = 0;
    private int z = 0;

    private Coordinates() {
    }

    public Coordinates(Coordinates coordinates) {
        this.x = coordinates.getX();
        this.y = coordinates.getY();
        this.z = coordinates.getZ();
    }

    public static Coordinates getInstance() {
        return new Coordinates(0, 0, 0);
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(int z, int x, int y) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        if (z < 0)
            z = 0;
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

    public void setCoordinates(Coordinates coordinates) {
        this.x = coordinates.getX();
        this.y = coordinates.getY();
        this.z = coordinates.getZ();
    }

    @Override
    public String toString() {
        return "Coordinates{ x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        if (z != that.z) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }
}
