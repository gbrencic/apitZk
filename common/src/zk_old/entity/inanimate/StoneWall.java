package zk_old.entity.inanimate;

import zk_old.entity.EntityImpl;
import zk_old.entity.EntityType;
import pleasantnightmare.movment.Coordinates;
import zk_old.stage.TextGraphics;

/**
 * User: gbrencic
 * Date: 03.04.12.
 * Time: 12:48
 */
public class StoneWall extends EntityImpl {
    public StoneWall(Coordinates coordinates) {
        super(EntityType.TILE,TextGraphics.STONE_WALL, coordinates);
        getStatus().riseHpBy(40);
    }

    @Override
    public void endTurnUpdate() {
        super.endTurnUpdate();
    }
}
