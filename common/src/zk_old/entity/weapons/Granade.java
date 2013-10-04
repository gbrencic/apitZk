package zk_old.entity.weapons;

import zk_old.entity.Entity;
import zk_old.entity.EntityImpl;
import zk_old.entity.EntityType;
import zk_old.entity.actions.Explosion;
import pleasantnightmare.movment.Coordinates;
import zk_old.stage.TextGraphics;

/**
 * User: gbrencic
 * Date: 22.03.12.
 * Time: 15:25
 */
public class Granade extends EntityImpl {
    private int timer = 6;
    private int distance = 5;

    public Granade(Coordinates coordinates) {
        super(EntityType.WEAPON, TextGraphics.BOMB, coordinates);
        addDeathAction(new Explosion());
    }

    @Override
    public void interact(Entity entity) {
        die();
    }

    @Override
    public void endTurnUpdate() {
        super.endTurnUpdate(); //Mozda ne treba za sve status

        move();

        timer--;
        if (timer == 0) {
            die();
        }
    }

    private void move() {
        if (distance > 0) {
            distance--;
            getMovement().moveRight();
        }
    }

    @Override
    public void die() {
        super.die();
    }
}
