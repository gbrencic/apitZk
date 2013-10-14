package hr.zk.common.entity.state.behaviour;

/**
 * User: gbrencic
 * Date: 14.10.13.
 * Time: 14:06
 */
public interface ExpirableUpdatableBehaviour extends UpdatableBehaviour {
    boolean isExpired();

    void expire();
}
