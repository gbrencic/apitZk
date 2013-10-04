package hr.zk.common.util.time;

/**
 * User: gbrencic
 * Date: 01.10.13.
 * Time: 15:54
 */
public class DeltaUtil {
    public float calculateDelta(int delta, int speed) {
        return speed * delta / 1000f;
    }
}
