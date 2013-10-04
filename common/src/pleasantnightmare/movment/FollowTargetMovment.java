package pleasantnightmare.movment;

import zk_old.entity.Entity;

/**
 * User: gbrencic
 * Date: 04.04.12.
 * Time: 14:30
 */
public class FollowTargetMovment extends Movement {
    private Entity target;

    public FollowTargetMovment(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void doMove() {
        int targetX = target.getCoordinates().getX();
        int targetY = target.getCoordinates().getY();

        int thisX = getEndPosition().getX();
        int thisY = getEndPosition().getY();

        if (thisX < targetX) {
            moveRight();
        } else if (thisX > targetX) {
            moveLeft();
        } else if (thisY > targetY) {
            moveUp();
        } else if (thisY < targetY) {
            moveDown();
        }
    }

    public void setTarget(Entity target) {
        this.target = target;
    }
}
