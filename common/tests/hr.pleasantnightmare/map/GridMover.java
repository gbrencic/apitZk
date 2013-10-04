package hr.pleasantnightmare.map;

import pleasantnightmare.movment.Coordinates;
import pleasantnightmare.movment.GridMovement;
import org.newdawn.slick.geom.Circle;

/**
 * User: gbrencic
 * Date: 31.08.12.
 * Time: 14:38
 */
public class GridMover {
    private final int gridSize;
    private Circle shape;
    private GridMovement movement;


    public GridMover(int x, int y, int gridSize) {

        this.gridSize = gridSize;
        shape = new Circle(gridSize * x - 16, gridSize * y - 16, 16);
        movement = new GridMovement(new Coordinates(x, y), gridSize);
    }

    public void update(int delta) {
        movement.doMove();
        shape.setX(movement.getX());
        shape.setY(movement.getY());
    }

    public Circle getShape() {
        return shape;
    }

    public void setShape(Circle shape) {
        this.shape = shape;
    }

    public void moveRight() {
        movement.moveRight();
    }
}
