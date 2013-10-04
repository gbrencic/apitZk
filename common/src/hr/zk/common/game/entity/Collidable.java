package hr.zk.common.game.entity;

/**
 * User: gbrencic
 * Date: 02.10.13.
 * Time: 12:09
 */
public interface Collidable {

    boolean collidesWith(Collidable colidable);

    boolean collideWith(Collidable colidable);

}
