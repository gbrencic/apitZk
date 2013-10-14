package hr.zk.common.entity;

import hr.zk.common.entity.state.EntityState;
import org.newdawn.slick.Animation;

import java.util.HashMap;

/**
 * User: gbrencic
 * Date: 14.10.13.
 * Time: 13:50
 */
public class DefaultStatefulEntity extends DefaultEntity implements StatefulEntity {
    private EntityState selectedState;
    private Animation selectedGraphics;
    private HashMap<String, EntityState> states = new HashMap<String, EntityState>();
    private HashMap<String, Animation> graphics = new HashMap<String, Animation>();

    public DefaultStatefulEntity(Long id, String name, float posX, float posY) {
        super(id, name, posX, posY);
    }

    public DefaultStatefulEntity(Long id, String name, float posX, float posY, Role role) {
        super(id, name, posX, posY, role);
    }

    @Override
    public EntityState getSelectedState() {
        return selectedState;
    }

    @Override
    public void setSelectedState(String stateId) { //TODO neki enum
        this.selectedState = states.get(stateId);
    }

    @Override
    public void addState(EntityState normalState) {
        states.put(normalState.getId(), normalState);
    }

    public void addGraphics(String graphicName, Animation animation) {
        graphics.put(graphicName, animation);
    }

    public Animation getSelectedGraphics() {
        return selectedGraphics;
    }

    @Override
    public void setSelectedGraphic(String graphicName) {   //TODO neki enum
        selectedGraphics = graphics.get(graphicName);
    }
}
