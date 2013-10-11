package pleasantnightmare.entity;

import hr.zk.common.entity.DefaultRoles;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.19
 * Time: 11:11:31
 * To change this template use File | Settings | File Templates.
 */
public abstract class ConstantlyMovableBody extends MovableBody {
    protected ConstantlyMovableBody(String id, int posX, int posY, DefaultRoles role, int speed, int xVelocity, int yVelocity) {
        super(id, posX, posY, role, speed, xVelocity, yVelocity);
    }

    public void doMove(int delta) {
        moveX(delta);
        moveY(delta);
    }

    private void moveX(int delta) {
        //TODO delta util
//        float move = DeltaUtil.calculateDelta(delta, getXVelocity());
//        posX = posX + move;
    }

    private void moveY(int delta) {
//        float move = DeltaUtil.calculateDelta(delta, getYVelocity());
//        posY = posY + move;
    }

}