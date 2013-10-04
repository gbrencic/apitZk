package hr.pleasantnightmare.network.simplegame.messages;

/**
 * User: gbrencic
 * Date: 30.08.12.
 * Time: 09:28
 */
public class MoveBulletMessage {
    private int id;
    private float toX;
    private float toY;

    public MoveBulletMessage() {
    }

    public int getId() {
        return id;
    }

    public float getToX() {
        return toX;
    }

    public float getToY() {
        return toY;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setToX(float toX) {
        this.toX = toX;
    }

    public void setToY(float toY) {
        this.toY = toY;
    }
}


