package zk_old.entity.spawning;

import zk_old.entity.EntityImpl;
import zk_old.entity.EntityType;
import zk_old.entity.creatures.DarkCreature;
import zk_old.stage.MapTile;
import zk_old.stage.Stage;
import zk_old.stage.TextGraphics;
import pleasantnightmare.movment.Coordinates;

import java.util.Random;

/**
 * User: gbrencic
 * Date: 03.04.12.
 * Time: 11:16
 */
public class DarkCreatureSpawnPoint extends EntityImpl {
    private Stage stage;

    public DarkCreatureSpawnPoint(Coordinates coordinates, Stage stage) {
        super(EntityType.STAGE_OBJECT,TextGraphics.SPAWN_POINT, coordinates);
        this.stage = stage;
    }

    @Override
    public void endTurnUpdate() {
        int random = new Random().nextInt(20);
        if (random < 18)
            return;

        final Coordinates coordinates = new Coordinates(getCoordinates());
        coordinates.setX(coordinates.getX() + 1);

        final MapTile spawnTile = stage.getMap().getTileAt(coordinates);

        if (spawnTile.isEntityReciever()) {
            stage.addEntityBeforeUpdate(new DarkCreature(coordinates));
        }
    }
}
