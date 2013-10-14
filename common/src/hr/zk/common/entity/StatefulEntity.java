package hr.zk.common.entity;

import hr.zk.common.entity.state.EntityState;

/**
 * User: gbrencic
 * Date: 14.10.13.
 * Time: 13:47
 */
public interface StatefulEntity extends Entity {
    EntityState getSelectedState();

    void setSelectedState(String stateId);

    void addState(EntityState normalState);

    void setSelectedGraphic(String graphicName);
}
