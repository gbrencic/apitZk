package hr.zk.common.util.time;

/**
 * User: gbrencic
 * Date: 01.10.13.
 * Time: 15:54
 */
public class DeltaUtil {
    //TODO da ne bude static interface
    public static float calculateDelta(int delta, int speed) {
        return speed * delta / 1000f;
    }
}
