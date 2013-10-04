package zk_old.entity;

import zk_old.entity.actions.DeathAction;
import pleasantnightmare.movment.Coordinates;
import zk_old.stage.BaseMap;
import zk_old.stage.MapTile;
import zk_old.stage.Stage;

/**
 * User: gbrencic
 * Date: 22.03.12.
 * Time: 12:37
 */
public class EntityActionController {
    public void doActions(Stage stage) {
        for (Entity entity : stage.getEntityList()) {
            entity.endTurnUpdate();
            moveEntity(entity, stage.getMap());
            doTileEffects(entity, stage.getMap());
            doGravity(entity, stage.getMap());
            executeOnDeathActions(entity, stage);
        }
    }

    public static void moveEntity(Entity entity, BaseMap map) {
        if (!entity.isAlive() || !entity.getMovement().hasMoved())
            return;
        Coordinates startCoordinates = entity.getMovement().getStartPosition();
        Coordinates endCoordinates = entity.getMovement().getEndPosition();

        if (!map.mapContainsCoordinates(endCoordinates)) {
            entity.getMovement().resetMove();
            return;
        }

        MapTile startMapTile = map.getTileAt(startCoordinates);
        MapTile endMapTile = map.getTileAt(endCoordinates);

        //Interact with entity on end tile
        if (endMapTile.containsMainEntity()) {
            entity.interact(endMapTile.getMainEntity());
        }

        //Move the entity
        if (endMapTile.isEntityReciever()) {
            startMapTile.transferMainEntityToTile(endMapTile);
            entity.getMovement().finishMovment();
        } else if (endMapTile.isWalkOver() && startMapTile.getCoordinates().getZ() == endMapTile.getCoordinates().getZ()) {
            Coordinates c = new Coordinates(endCoordinates);
            c.setZ(c.getZ() + 1);
            entity.getMovement().setEndCoordinates(c);
            MapTile overMapTile = map.getTileAt(c);
            if (!overMapTile.isEntityReciever()) {
                entity.getMovement().resetMove();
            } else {
                startMapTile.transferMainEntityToTile(overMapTile);
            }
            entity.getMovement().finishMovment();
        } else if (entity.getMovement().hasMoved()) {
            entity.getMovement().resetMove();
        }
    }

    private static void doTileEffects(Entity entity, BaseMap map) {
        MapTile endMapTile = map.getTileAt(entity.getMovement().getEndPosition());
        if (endMapTile.containsEffectEntity()) {
            entity.interact(endMapTile.getEffectEntity());
            endMapTile.getEffectEntity().interact(entity);
        }
    }

    private static void doGravity(Entity entity, BaseMap map) {
        if (entity.isGravityAffected() && entity.getMovement().getEndPosition().getZ() > 0) {
            entity.getMovement().loverLevel();
            moveEntity(entity, map);
        }
    }

    private void executeOnDeathActions(Entity entity, Stage stage) {
        if (entity.isAlive())
            return;
        for (DeathAction onDeathAction : entity.getOnDeathActions()) {
            onDeathAction.doAction(entity, stage);
        }
    }
}
