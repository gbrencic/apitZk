package pleasantnightmare.movment;

/**
 * User: gbrencic
 * Date: 21.03.12.
 * Time: 15:25
 */
public class Movement {
    private final Coordinates endPosition = Coordinates.getInstance();
    private final Coordinates startPosition = Coordinates.getInstance();

    public Movement(Coordinates coordinates) {
        this.endPosition.setCoordinates(coordinates);
        this.startPosition.setCoordinates(coordinates);
    }

    public void setCoordinates(Coordinates coordinates) {
        this.endPosition.setCoordinates(coordinates);
        this.startPosition.setCoordinates(coordinates);
    }

    public void setStartCoordinates(Coordinates coordinates) {
        this.endPosition.setCoordinates(coordinates);
    }

    public void setEndCoordinates(Coordinates coordinates) {
        this.endPosition.setCoordinates(coordinates);
    }

    public Coordinates getEndPosition() {
        return endPosition;
    }

    public Coordinates getStartPosition() {
        return startPosition;
    }

    public void doMove() {
    }

    public void moveUp() {
        startPosition.setCoordinates(endPosition);
        endPosition.setY(endPosition.getY() - 1);
    }

    public void moveDown() {
        startPosition.setCoordinates(endPosition);
        endPosition.setY(endPosition.getY() + 1);
    }

    public void moveLeft() {
        startPosition.setCoordinates(endPosition);
        endPosition.setX(endPosition.getX() - 1);
    }

    public void moveRight() {
        startPosition.setCoordinates(endPosition);
        endPosition.setX(endPosition.getX() + 1);
    }

    public void riseLevel() {
        startPosition.setCoordinates(endPosition);
        endPosition.setZ(endPosition.getZ() + 1);
    }

    public void loverLevel() {
        startPosition.setCoordinates(endPosition);
        endPosition.setZ(endPosition.getZ() - 1);
    }

    public void resetMove() {
        endPosition.setCoordinates(startPosition);
    }

    public void finishMovment() {
        startPosition.setCoordinates(endPosition);
    }

    public boolean hasMoved() {
        return !startPosition.equals(endPosition);
    }
}
