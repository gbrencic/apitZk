package hr.zk.common.entity.state.behaviour;

import hr.zk.common.entity.DefaultRoles;
import hr.zk.common.entity.Entity;

/**
 * User: gbrencic
 * Date: 14.10.13.
 * Time: 12:29
 */
public class WallCollisionBehaviourTest implements InteractionBehaviour {
    private Entity owner;

    public WallCollisionBehaviourTest(Entity owner) {
        this.owner = owner;
    }

    @Override
    public void interact(Entity entity) {
        if (entity.getRole().equals(DefaultRoles.OBSTACLE))
        System.out.println(owner.getName() + " collided with a wall. ");
    }
}
