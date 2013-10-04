package zk_old.entity.creatures;

import zk_old.entity.Entity;
import zk_old.entity.EntityImpl;
import zk_old.entity.EntityType;
import zk_old.entity.actions.RestoreHealthToTarget;
import zk_old.model.InfoMessageBuffer;
import pleasantnightmare.movment.Coordinates;
import pleasantnightmare.movment.FollowTargetMovment;
import pleasantnightmare.movment.RandomMovment;
import zk_old.stage.TextGraphics;

import java.util.Random;

/**
 * User: gbrencic
 * Date: 22.03.12.
 * Time: 15:24
 */
public class LightCreature extends EntityImpl {
    private final RestoreHealthToTarget restoreHealthToTarget = new RestoreHealthToTarget();
    private FollowTargetMovment followMovment;
    private RandomMovment randomMovment;
    private Entity target;

    public LightCreature(Coordinates coordinates) {
        super(EntityType.CREATURE,TextGraphics.SUN, coordinates);
        addDeathAction(restoreHealthToTarget);

        followMovment = new FollowTargetMovment(coordinates);
        setMovement(followMovment);
        randomMovment = new RandomMovment(coordinates);
    }

    @Override
    public void interact(Entity entity) {

    }

    @Override
    public void endTurnUpdate() {
        //getStatus().lowerHpBy(100);

        super.endTurnUpdate();

        int move = new Random().nextInt(5);
        if (move <= 3 && isTargetVisible()) {
            setMovement(followMovment);
        } else {
            setMovement(randomMovment);
        }
        getMovement().doMove();
    }

    private boolean isTargetVisible() {  //Todo LOS
        int targetX = target.getCoordinates().getX();
        int targetY = target.getCoordinates().getY();

        int thisX = getCoordinates().getX();
        int thisY = getCoordinates().getY();

        int distanceX = Math.abs(thisX - targetX);
        int distanceY = Math.abs(thisY - targetY);

        if (distanceX <= 5 && distanceY <= 5)
            return true;

        return false;
    }

    public void setTargetToFollow(Entity target) {
        this.target = target;
        followMovment.setTarget(target);
        restoreHealthToTarget.setTarget(target);
    }

    @Override
    public void die() {
        super.die();
        InfoMessageBuffer.addInfoMessage("Light Creature dies!");
    }
}
