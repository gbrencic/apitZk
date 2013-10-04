package pleasantnightmare.movment;

/**
 * User: gbrencic
 * Date: 31.08.12.
 * Time: 14:49
 */
public class GridMovement extends Movement {
    private float x;
    private float y;
    private float speed = 0.25f;
    private int step = 0;

    private int gridSize;


    public GridMovement(Coordinates coordinates, int gridSize) {
        super(coordinates);
        this.gridSize = gridSize;
    }

    @Override
    public void doMove() {
        if (Math.round(x) == getEndPosition().getX() && Math.round(y) == getEndPosition().getY()) {
            finishMovment();
            return;
        }

        step++;
        if(step >= 4)
            step = 1;



        x = getStartPosition().getX() * (gridSize * speed)*step;
        y = getStartPosition().getY() * (gridSize * speed)*step;
    }

    private int getGridLocation(float pos) {
        return Math.round(pos / gridSize);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
