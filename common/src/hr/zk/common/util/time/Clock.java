package hr.zk.common.util.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: gbrencic
 * Date: 01.10.13.
 * Time: 15:56
 */
public class Clock {
    private static long timer;
    private static long publicTimer;
    private static SimpleDateFormat sdf;

    public Clock() {
        timer = 0;
        publicTimer = 0;
        sdf = new SimpleDateFormat("mm:ss");
    }

    public void update(int delta) {
        timer += delta;
        if (timer >= 1000) {
            publicTimer++;
            timer = 0;
        }
    }

    /**
     * @return time formatted in mm:ss
     */
    public static String getTime() {
        return sdf.format(new Date(publicTimer * 1000));
    }

    /**
     * @return time passed in milliseconds
     */
    public static long getTimer() {
        return publicTimer;
    }
}
