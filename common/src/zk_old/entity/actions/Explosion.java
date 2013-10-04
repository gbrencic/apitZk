package zk_old.entity.actions;

import zk_old.entity.Entity;
import zk_old.entity.weapons.LargeFire;
import zk_old.entity.weapons.SmallFire;
import zk_old.stage.MapTile;
import zk_old.stage.Stage;
import pleasantnightmare.movment.Coordinates;

/**
 * User: gbrencic
 * Date: 04.04.12.
 * Time: 11:48
 */
public class Explosion implements DeathAction {

    public void doAction(Entity entity, Stage stage) {
        explode(entity.getCoordinates(), stage);
    }

    private void explode(Coordinates coordinates, Stage stage) {
        coordinates.setX(coordinates.getX() - 1);                //Ove ne updejta dok ne krene u sljedeci turn
        spawnLargeFlame(coordinates, stage);

        coordinates.setX(coordinates.getX() - 1);                //Ove ne updejta dok ne krene u sljedeci turn
        spawnSmallFlame(coordinates, stage);

        coordinates.setX(coordinates.getX() + 3);
        spawnLargeFlame(coordinates, stage);

        coordinates.setX(coordinates.getX() + 1);
        spawnSmallFlame(coordinates, stage);

        coordinates.setX(coordinates.getX() - 2); // 0

        coordinates.setY(coordinates.getY() - 1);                //Ove ne updejta dok ne krene u sljedeci turn
        spawnLargeFlame(coordinates, stage);
        coordinates.setY(coordinates.getY() - 1);               //Ove ne updejta dok ne krene u sljedeci turn
        spawnSmallFlame(coordinates, stage);

        coordinates.setY(coordinates.getY() + 3);
        spawnLargeFlame(coordinates, stage);
        coordinates.setY(coordinates.getY() + 1);
        spawnSmallFlame(coordinates, stage);
    }

    private void spawnLargeFlame(Coordinates coordinates, Stage stage) {
        final MapTile spawnTile = stage.getMap().getTileAt(coordinates);
        if (spawnTile.isEntityReciever()) {
            stage.addEntityAfterUpdate(new LargeFire(coordinates));
        } else {
            if (spawnTile.containsMainEntity())
                new LargeFire(coordinates).interact(spawnTile.getMainEntity());
        }
    }

    private void spawnSmallFlame(Coordinates coordinates, Stage stage) {
        final MapTile spawnTile = stage.getMap().getTileAt(coordinates);
        if (spawnTile.isEntityReciever()) {
            stage.addEntityAfterUpdate(new SmallFire(coordinates));
        } else {
            if (spawnTile.containsMainEntity())
                new SmallFire(coordinates).interact(spawnTile.getMainEntity());
        }
    }
}
