package zk_old.entity.weapons;

import zk_old.entity.Entity;
import zk_old.entity.EntityImpl;
import zk_old.entity.EntityType;
import pleasantnightmare.movment.Coordinates;
import zk_old.stage.TextGraphics;

/**
 * User: gbrencic
 * Date: 03.04.12.
 * Time: 12:08
 */
public class Bullet extends EntityImpl {
    private int timer = 10;

    public Bullet(Coordinates coordinates) {
        super(EntityType.WEAPON, TextGraphics.BULLET, coordinates);
    }

    @Override
    public void interact(Entity entity) {
        entity.getStatus().lowerHpBy(5);
        die();
    }

    @Override
    public void endTurnUpdate() {
        timer--;
        if (timer == 0)
            die();
        getMovement().moveRight();
    }
}
