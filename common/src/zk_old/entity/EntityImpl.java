package zk_old.entity;

import zk_old.entity.actions.DeathAction;
import zk_old.game.engine.Status;
import pleasantnightmare.movment.Coordinates;
import pleasantnightmare.movment.Movement;

import java.util.LinkedList;
import java.util.List;

/**
 * User: gbrencic
 * Date: 02.03.12.
 * Time: 14:40
 */
public abstract class EntityImpl implements Entity {
    private int size = 1;
    private boolean alive = true;
    private boolean blocksMovment = true;
    private boolean gravityAffected = true;
    private EntityType entityType;
    private String graphic;

    private Movement movement;
    private final Status status;
    private List<DeathAction> deathActions = new LinkedList<DeathAction>();

    public EntityImpl(EntityType entityType, String graphic, Coordinates coordinates) {
        this.entityType = entityType;
        this.graphic = graphic;
        this.movement = new Movement(coordinates);
        this.status = new Status();
    }

    public String getGraphics() {
        return graphic;
    }

    public void setGraphics(String graphic) {
        this.graphic = graphic;
    }

    public void endTurnUpdate() {
        status.update();

        if (this.getStatus().getHp() <= 0 && isAlive())
            die();
    }

    public void interact(Entity entity) {
    }

    public boolean isBlockMovement() {
        return blocksMovment;
    }

    public void setBlocksMovment(boolean blocksMovment) {
        this.blocksMovment = blocksMovment;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        movement.setCoordinates(getCoordinates());
        this.movement = movement;
    }

    public Coordinates getCoordinates() {
        return movement.getStartPosition();
    }

    public Status getStatus() {
        return status;
    }

    public void die() {
        alive = false;
        setBlocksMovment(false);
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isGravityAffected() {
        return gravityAffected;
    }

    public void setGravityAffected(boolean gravityAffected) {
        this.gravityAffected = gravityAffected;
    }


    public void addDeathAction(DeathAction deathAction) {
        this.deathActions.add(deathAction);
    }

    public List<DeathAction> getOnDeathActions() {
        return deathActions;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    /**
     * How many n*n squares does occupy
     */
    public int getSize() {
        return size;
    }

    /**
     * How many n*n squares does occupy
     */
    public void setSize(int size) {
        this.size = size;
    }
}
