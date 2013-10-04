package zk_old.entity.inanimate;

import zk_old.entity.Entity;
import zk_old.entity.EntityImpl;
import zk_old.entity.EntityType;
import pleasantnightmare.movment.Coordinates;
import zk_old.stage.TextGraphics;

/**
 * User: gbrencic
 * Date: 05.04.12.
 * Time: 15:34
 */
public class Tree extends EntityImpl {
    public Tree(Coordinates coordinates) {
        super(EntityType.STAGE_OBJECT, TextGraphics.TREE, coordinates);
    }

    @Override
    public void interact(Entity entity) {
        entity.getStatus().riseHpBy(5);
        this.getStatus().lowerHpBy(10);
    }
}
