package hr.pleasantnightmare.network.simplegame.messages;

/**
 * User: gbrencic
 * Date: 30.08.12.
 * Time: 09:28
 */
public class MoveCharacterMessage {
    private final int id;
    private final float toX;
    private final float toY;

    public MoveCharacterMessage(int id, float toX, float toY) {
        this.id = id;
        this.toY = toY;
        this.toX = toX;
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
}
