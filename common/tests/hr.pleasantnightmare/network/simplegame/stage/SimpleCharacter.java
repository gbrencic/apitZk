package hr.pleasantnightmare.network.simplegame.stage;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * User: gbrencic
 * Date: 29.08.12.
 * Time: 13:26
 */
public class SimpleCharacter {
    private final Integer id;
    private float posX = 0;
    private float posY = 0;
    private transient int direction = 1; //1u2d3l4r
    private Rectangle shape = null;


    public SimpleCharacter(Integer id, int posX, int posY) {
        this.id = id;
        this.posX = posX;
        this.posY = posY;

        shape = new Rectangle(posX, posY, 10, 10);
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

    public Integer getId() {
        return id;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
