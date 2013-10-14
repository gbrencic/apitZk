package hr.zk.common.entity.state.behaviour;

import hr.zk.common.entity.StatefulEntity;
import hr.zk.common.entity.state.EntityState;

/**
 * User: gbrencic
 * Date: 14.10.13.
 * Time: 12:29
 */
public class HasteUpdatableBehaviourTest implements ExpirableUpdatableBehaviour {
    private StatefulEntity owner;
    private int expireIn = 2;
    private int counter = 0;
    private boolean expired = false;

    public HasteUpdatableBehaviourTest(StatefulEntity owner) {
        this.owner = owner;
    }

    @Override
    public void update(int delta) {
        if (expired)
            return;

        if (counter == 0) {
            final EntityState state = owner.getSelectedState();
            final ControlBehaviour movment = state.getControlBehaviour();
            movment.setSpeed(movment.getSpeed() * 2);
        }

        counter++;

        if (counter > expireIn) {
            expire();
            final EntityState state = owner.getSelectedState();
            final ControlBehaviour movment = state.getControlBehaviour();
            movment.setSpeed(movment.getSpeed() / 2);
        }
    }

    @Override
    public boolean isExpired() {
        return expired;
    }


    @Override
    public void expire() {
        expired = true;
    }
}
