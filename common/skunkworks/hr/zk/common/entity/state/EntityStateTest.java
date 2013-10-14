package hr.zk.common.entity.state;

import hr.zk.common.application.ApplicationContext;
import hr.zk.common.entity.DefaultRoles;
import hr.zk.common.entity.DefaultStatefulEntity;
import hr.zk.common.entity.StatefulEntity;
import hr.zk.common.entity.state.behaviour.*;

import static hr.zk.common.entity.state.behaviour.ControlBehaviourAction.RIGHT;
import static hr.zk.common.entity.state.behaviour.ControlBehaviourAction.SHOOT;

/**
 * User: gbrencic
 * Date: 14.10.13.
 * Time: 12:30
 */
public class EntityStateTest {
    public EntityStateTest() {
        final ApplicationContext app = new ApplicationContext();
        final StatefulEntity player = new DefaultStatefulEntity(1l, "Player", 0f, 0f, DefaultRoles.PLAYER);
        final StatefulEntity monster = new DefaultStatefulEntity(2l, "Monster", 0f, 0f, DefaultRoles.MONSTER);
        final StatefulEntity wall = new DefaultStatefulEntity(3l, "Wall", 0f, 0f, DefaultRoles.OBSTACLE);

        //Behaviours
        final InteractionBehaviour monsterCB = new MonsterCollisionBehaviourTest(player);
        final InteractionBehaviour wallCB = new WallCollisionBehaviourTest(player);
        final ControlBehaviour controlBehaviourNormal = new ControlBehaviourTest(player, app, 10);
        final ControlBehaviour controlBehaviourCrouch = new ControlBehaviourTest(player, app, 4);

        //ovo utjece na vise stateova odjednom
        //TODO razdjeliti na persistant i expirable
        final UpdatableBehaviour regenerationUB = new RegenerationUpdatableBehaviourTest(player);
        final ExpirableUpdatableBehaviour hasteUB = new HasteUpdatableBehaviourTest(player);

        //State Creation
        final EntityState normalState = new DefaultTestStateImpl("normal");
        normalState.addBehaviour(monsterCB);
        normalState.addBehaviour(wallCB);
        normalState.addBehaviour(regenerationUB);
        normalState.addBehaviour(controlBehaviourNormal);

        final EntityState crouchingState = new DefaultTestStateImpl("crouch");
        crouchingState.addBehaviour(monsterCB);
        crouchingState.addBehaviour(wallCB);
        crouchingState.addBehaviour(controlBehaviourCrouch);

        //Selecting state
        player.addState(normalState);
        player.setSelectedState("normal");

        //Interaction
        normalState.interact(monster);
        crouchingState.interact(monster);

        normalState.interact(wall);
        crouchingState.interact(wall);

        //Movment
        normalState.doAction(RIGHT, 1);
        crouchingState.doAction(RIGHT, 1);

        //Adding 'Haste' State
        normalState.addBehaviour(hasteUB);
        crouchingState.addBehaviour(hasteUB);

        //Update samo trenutno postavljenog statea - Behaviori su vezani referencom
        for (int i = 0; i < 10; i++) {
            normalState.update(1);
            normalState.doAction(RIGHT, 1);
        }

        //Shoot Bullet
        normalState.doAction(SHOOT, 1);
    }

    public static void main(String[] args) {
        new EntityStateTest();
    }
}
