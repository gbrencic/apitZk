package hr.pleasantnightmare.network.simplegame.stage;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

/**
 * User: gbrencic
 * Date: 30.08.12.
 * Time: 10:50
 */
public class SimpleBullet {
    private final Integer id;
    private float posX = 0;
    private float posY = 0;
    private int direction = 1;
    private Circle shape = null;

    public SimpleBullet(Integer id, float posX, float posY, int direction) {
        this.id = id;
        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
        shape = new Circle(posX, posY, 3);
    }

    public Shape getShape() {
        return shape;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
        shape.setX(posX);
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
        shape.setY(posY);
    }

    public int getDirection() {
        return direction;
    }

    public Integer getId() {
        return id;
    }
}
