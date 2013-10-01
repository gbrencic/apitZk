package hr.zk.common.util.time;

/**
 * User: gbrencic
 * Date: 01.10.13.
 * Time: 15:53
 */
public class MilisecondCounter {
    //TODO interface
    long time = System.currentTimeMillis();

    public void resetTime() {
        time = System.currentTimeMillis();
    }

    public void start() {
        resetTime();
    }

    public long timePassed() {
        return System.currentTimeMillis() - time;
    }
}
