package hr.zk.common.entity.state.behaviour;

import hr.zk.common.application.ApplicationContext;
import hr.zk.common.application.ApplicationContextAware;
import hr.zk.common.entity.StatefulEntity;

import static hr.zk.common.entity.state.behaviour.ControlBehaviourAction.*;

/**
 * User: gbrencic
 * Date: 14.10.13.
 * Time: 13:06
 */
public class ControlBehaviourTest implements ControlBehaviour, ApplicationContextAware {
    private StatefulEntity entity;
    private float speed;

    //TODO treba li zaista app context...
    public ControlBehaviourTest(StatefulEntity entity, ApplicationContext applicationContext, float speed) {
        this.entity = entity;
        this.speed = speed;
    }

    @Override
    public void doAction(ControlBehaviourAction action, int delta) {
        if (action.equals(LEFT)) {
            entity.setPosX(entity.getPosX() - (speed * delta / 100f));
            entity.setSelectedGraphic("left");
        }

        if (action.equals(RIGHT)) {
            entity.setPosX(entity.getPosX() + (speed * delta / 100f));
            entity.setSelectedGraphic("right");
        }

        if (action.equals(UP)) {
            entity.setPosY(entity.getPosY() - (speed * delta / 100f));
        }

        if (action.equals(DOWN)) {
            entity.setPosY(entity.getPosY() + (speed * delta / 100f));
        }

        if (action.equals(SHOOT)) {
            //Do stuff sa app context ili samim playerom....
        }
        //moguci dodaci
        //Na klik zapocni interakciju s necime sto je pored Entitya  - ap contex get entiti na x,y tileu i onda  entity.getSelectedState().interact(ENTITY);
        //Spawnanje svega i svacega...
        //inventar ???

        //Sto ako se gleda vise keyeva recimo right i up treba li uvijek proci sve slucajeve?
        //Ili se gleda napad u zraku ili zemlji...
        //tko ima animaciju i boundry boxza koliziju
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
