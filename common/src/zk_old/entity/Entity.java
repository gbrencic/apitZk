package zk_old.entity;

import zk_old.entity.actions.DeathAction;
import zk_old.game.engine.Status;
import pleasantnightmare.movment.Coordinates;
import pleasantnightmare.movment.Movement;

import java.util.List;

/**
 * User: gbrencic
 * Date: 22.03.12.
 * Time: 12:15
 */
public interface Entity {
    String getGraphics();

    void endTurnUpdate();

    boolean isBlockMovement();

    boolean isAlive();

    List<DeathAction> getOnDeathActions();

    Coordinates getCoordinates();

    Movement getMovement();

    void interact(Entity entity);

    Status getStatus();

    boolean isGravityAffected();

    /**
     * How many n*n squares does occupy
     */
    int getSize();

    EntityType getEntityType();
}
