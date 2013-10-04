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
public class Bomb extends EntityImpl {
    private int timer = 5;

    public Bomb(Coordinates coordinates) {
        super(EntityType.WEAPON, TextGraphics.BOMB, coordinates);
        addDeathAction(new Explosion());
    }

    @Override
    public void interact(Entity entity) {
    }

    @Override
    public void endTurnUpdate() {
        super.endTurnUpdate(); //Mozda ne treba za sve status

        timer--;
        if (timer == 0) {
            die();
        }
    }

    @Override
    public void die() {
        super.die();
    }
}
