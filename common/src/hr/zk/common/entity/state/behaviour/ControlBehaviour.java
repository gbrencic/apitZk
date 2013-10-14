package hr.zk.common.entity.state.behaviour;

/**
 * User: gbrencic
 * Date: 14.10.13.
 * Time: 12:57
 */
public interface ControlBehaviour {
    void doAction(ControlBehaviourAction action, int delta);

    float getSpeed();

    void setSpeed(float speed);
}
