package hr.zk.common.entity.state.behaviour;

import hr.zk.common.entity.StatefulEntity;

/**
 * User: gbrencic
 * Date: 14.10.13.
 * Time: 12:29
 */
public class RegenerationUpdatableBehaviourTest implements UpdatableBehaviour {
    private StatefulEntity owner;
    private int trigger = 2;
    private int counter = 0;

    public RegenerationUpdatableBehaviourTest(StatefulEntity owner) {
        this.owner = owner;
    }

    @Override
    public void update(int delta) {
        counter++;
        System.out.println(owner.getName() + " updated for " + delta + " to " + counter);

        if (trigger == counter) {
            System.out.println("Healing++");
            counter = 0;
        }
    }
}
