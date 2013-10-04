package hr.pleasantnightmare.network.simplegame.messages;

/**
 * User: gbrencic
 * Date: 30.08.12.
 * Time: 10:53
 */
public class ShootMessage {
    private final float posX;
    private final float posY;
    private final int direction;

    public ShootMessage(float posX, float posY, int direction) {
        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public int getDirection() {
        return direction;
    }
}
