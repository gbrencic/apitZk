package zk_old.entity.creatures;

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
public class BasicPlayer extends EntityImpl {
    public BasicPlayer(Coordinates coordinates) {
        super(EntityType.CREATURE, TextGraphics.PLAYER, coordinates);
    }

    @Override
    public void interact(Entity entity) {
        if (entity.getEntityType().equals(EntityType.STAGE_OBJECT))
            entity.interact(this);
    }
}
