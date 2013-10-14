package hr.zk.common.entity.state;

import hr.zk.common.entity.Entity;
import hr.zk.common.entity.state.behaviour.*;

import java.util.Set;

/**
 * User: gbrencic
 * Date: 14.10.13.
 * Time: 12:28
 */
public interface EntityState {
    public String getId();

    void addBehaviour(InteractionBehaviour collisionBehaviour);

    void addBehaviour(UpdatableBehaviour updatableBehaviour);

    void addBehaviour(ExpirableUpdatableBehaviour updatableBehaviour);

    void addBehaviour(ControlBehaviour movementBehaviour);

    Set<InteractionBehaviour> getInteractionBehaviourSet();

    Set<UpdatableBehaviour> getUpdatableBehaviourSet();

    Set<ExpirableUpdatableBehaviour> getExpirableUpdatableBehaviourSet();

    ControlBehaviour getControlBehaviour();

    void interact(Entity entity);

    void update(int delta);

    void doAction(ControlBehaviourAction action, int delta);
}
