package hr.zk.common.entity.collision;

import hr.zk.common.entity.Role;
import org.newdawn.slick.geom.Shape;

/**
 * User: gbrencic
 * Date: 02.10.13.
 * Time: 12:09
 */
public interface Collidable {

    boolean collidesWith(Collidable colidable);

    void collideWith(Collidable colidable);

    Shape getCollisionShape();

    Role getRole();

}
