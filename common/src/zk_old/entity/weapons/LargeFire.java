package zk_old.entity.weapons;

import zk_old.entity.Entity;
import zk_old.entity.EntityImpl;
import zk_old.entity.EntityType;
import pleasantnightmare.movment.Coordinates;
import zk_old.stage.TextGraphics;

/**
 * User: gbrencic
 * Date: 22.03.12.
 * Time: 15:25
 */
public class LargeFire extends EntityImpl {
    private int timer = 6;

    public LargeFire(Coordinates coordinates) {
        super(EntityType.EFFECT, TextGraphics.FIRE_LARGE, coordinates);
        setBlocksMovment(false);
    }

    @Override
    public void interact(Entity entity) {
        entity.getStatus().lowerHpBy(20);
    }

    @Override
    public void endTurnUpdate() {
        super.endTurnUpdate(); //Mozda ne treba za sve status
        timer--;
        if (timer == 0) {
            die();
        } else if (timer == 3) {
            setGraphics(TextGraphics.FIRE_SMALL);
        }
    }
}
