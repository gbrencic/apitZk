package zk_old.entity.inanimate;

import zk_old.entity.Entity;
import zk_old.entity.EntityImpl;
import zk_old.entity.EntityType;
import pleasantnightmare.movment.Coordinates;
import zk_old.stage.TextGraphics;

/**
 * User: gbrencic
 * Date: 03.04.12.
 * Time: 12:48
 */
public class FloorWall extends EntityImpl {
    public FloorWall(Coordinates coordinates) {
        super(EntityType.WALKABLE_TILE, TextGraphics.WALL, coordinates);
    }

    @Override
    public void interact(Entity entity) {
        //Recimo ako entiti ima equipan shovel napravi nesto
    }

    @Override
    public void endTurnUpdate() {
        super.endTurnUpdate();
    }
}
