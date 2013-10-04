package pleasantnightmare.collision;

import org.newdawn.slick.geom.Rectangle;
import pleasantnightmare.entity.BasicRoles;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.23
 * Time: 13:22:20
 * To change this template use File | Settings | File Templates.
 */
public interface Collidable {
    void collide(Collidable obstacle);

    Rectangle getCollisionShape();

    BasicRoles getRole();
}
