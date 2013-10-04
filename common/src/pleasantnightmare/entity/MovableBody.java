package pleasantnightmare.entity;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.19
 * Time: 11:11:31
 * To change this template use File | Settings | File Templates.
 */
public abstract class MovableBody extends Body {
    private float moveToPosX;
    private float moveToPosY;
    private int xVelocity = 0;
    private int yVelocity = 0;
    private int speed;
    private float previousPosX;
    private float previousPosY;


    protected MovableBody(String id, int posX, int posY, BasicRoles role, int speed) {
        super(id, posX, posY, role);
        this.speed = speed;
    }

    protected MovableBody(String id, int posX, int posY, BasicRoles role, int speed, int xVelocity, int yVelocity) {
        super(id, posX, posY, role);
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.speed = speed;
    }

    public void moveTo(float posX, float posY) {
        moveToPosX = posX;
        moveToPosY = posY;
    }

    public void jumpTo(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void stopMoving() {
        moveToPosX = posX;
        moveToPosY = posY;
    }

    public void backUp() {
        this.posX = previousPosX;
        this.posY = previousPosY;
    }

    public void doMove(int delta) {
        previousPosX = this.posX;
        previousPosY = this.posY;
        moveX(delta);
        moveY(delta);
    }

    private void moveX(int delta) {
        if (moveToPosX == 0)
            return;

        float move = 0;//;DeltaUtil.calculateDelta(delta, speed + xVelocity);
        if (posX < moveToPosX) {
            posX = posX + move;
        }
        if (posX > moveToPosX)
            posX = posX - move;
    }

    private void moveY(int delta) {
        if (moveToPosY == 0)
            return;
                      //TODO delta util
        float move = 0;//DeltaUtil.calculateDelta(delta, speed + yVelocity);
        if (posY < moveToPosY)
            posY = posY + move;
        if (posY > moveToPosY)
            posY = posY - move;
    }

    public float getMoveToPosX() {
        return moveToPosX;
    }

    public void setMoveToPosX(float moveToPosX) {
        this.moveToPosX = moveToPosX;
    }

    public float getMoveToPosY() {
        return moveToPosY;
    }

    public void setMoveToPosY(float moveToPosY) {
        this.moveToPosY = moveToPosY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getXVelocity() {
        return xVelocity;
    }

    public void setXVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int getYVelocity() {
        return yVelocity;
    }

    public void setYVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }
}
