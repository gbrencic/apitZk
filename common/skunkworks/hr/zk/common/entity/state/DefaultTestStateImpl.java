package hr.zk.common.entity.state;

import hr.zk.common.entity.Entity;
import hr.zk.common.entity.state.behaviour.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * User: gbrencic
 * Date: 14.10.13.
 * Time: 12:29
 */
public class DefaultTestStateImpl implements EntityState {
    private final String stateId;
    private final Set<InteractionBehaviour> interactionBehaviourSet = new HashSet<InteractionBehaviour>();
    private final Set<UpdatableBehaviour> updatableBehaviourSet = new HashSet<UpdatableBehaviour>();
    private final Set<ExpirableUpdatableBehaviour> expirableUpdatableBehaviourSet = new HashSet<ExpirableUpdatableBehaviour>();
    private ControlBehaviour controlBehaviour;
    //TODO dodati animacije ili slike stogod

    public DefaultTestStateImpl(String stateId) {
        this.stateId = stateId;
    }

    @Override
    public void addBehaviour(InteractionBehaviour behaviour) {
        interactionBehaviourSet.add(behaviour);
    }

    @Override
    public void addBehaviour(UpdatableBehaviour updatableBehaviour) {
        updatableBehaviourSet.add(updatableBehaviour);
    }

    @Override
    public void addBehaviour(ExpirableUpdatableBehaviour updatableBehaviour) {
        expirableUpdatableBehaviourSet.add(updatableBehaviour);
    }

    @Override
    public void addBehaviour(ControlBehaviour movementBehaviour) {
        this.controlBehaviour = movementBehaviour;
    }

    @Override
    public Set<InteractionBehaviour> getInteractionBehaviourSet() {
        return interactionBehaviourSet;
    }

    @Override
    public Set<UpdatableBehaviour> getUpdatableBehaviourSet() {
        return updatableBehaviourSet;
    }

    public Set<ExpirableUpdatableBehaviour> getExpirableUpdatableBehaviourSet() {
        return expirableUpdatableBehaviourSet;
    }

    @Override
    public ControlBehaviour getControlBehaviour() {
        return controlBehaviour;
    }

    /**
     * Interact with other entitities
     *
     * @param entity - this entity interacts with param entity
     */
    @Override
    public void interact(Entity entity) {
        for (InteractionBehaviour behaviour : interactionBehaviourSet) {
            behaviour.interact(entity);
        }
    }

    /**
     * Updatable behaviour
     *
     * @param delta - time passed
     */
    @Override
    public void update(int delta) {
        updateBehaviours(delta);
        updateExpirableBehaviours(delta);
    }

    private void updateBehaviours(int delta) {
        for (UpdatableBehaviour behaviour : updatableBehaviourSet) {
            behaviour.update(delta);
        }
    }

    private void updateExpirableBehaviours(int delta) {
        Iterator<ExpirableUpdatableBehaviour> expIterator = expirableUpdatableBehaviourSet.iterator();
        while (expIterator.hasNext()) {
            final ExpirableUpdatableBehaviour behaviour = expIterator.next();
            if (behaviour.isExpired()) {
                expirableUpdatableBehaviourSet.remove(behaviour);
                continue;
            }
            behaviour.update(delta);
        }
    }

    @Override
    public void doAction(ControlBehaviourAction action, int delta) {
        controlBehaviour.doAction(action, delta);
    }

    public String getId() {
        return stateId;
    }
}
