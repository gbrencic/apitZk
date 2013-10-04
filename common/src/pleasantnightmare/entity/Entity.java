package pleasantnightmare.entity;


import pleasantnightmare.graphics.Animatable;
import pleasantnightmare.level.Level;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.15
 * Time: 13:23:51
 * To change this template use File | Settings | File Templates.
 */
public interface Entity extends Animatable {

    /**
* Helps identify an entity; mostly used when responding to a collision.
*
* @return
*/
    public int getRole();

    /**
* Add this entity to the given level, perform any necessary set up.
*
* In many cases this will not need to do anything. In cases where an entity
* dynamically creates other entities than the level should be stored so
* that new entities can be added.
*
* @param l
*/
    public void addToLevel(Level< ? > l);

    /**
* Called when this object is to be removed from the level.
*
* In almost all cases being removed from the level will mean being removed
* from the game. Therefore the entity should clean up any resources and
* pointers.
*
* @param l
*/
    public void removeFromLevel(Level < ? > l);

    /**
* Called when this objects collides with the obstacle.
*
* @param obstacle
*/
    public void onCollision(Entity obstacle);

    public float getPosX();

    public float getPosY();

}