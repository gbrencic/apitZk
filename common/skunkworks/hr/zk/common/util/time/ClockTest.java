package hr.zk.common.util.time;

/**
 * User: gbrencic
 * Date: 02.10.13.
 * Time: 11:04
 */
public class ClockTest {
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.update(2000);
        System.out.println(clock.getTime());
        System.out.println(clock.getTimer());
        clock.update(2000);
        System.out.println(clock.getTime());
        System.out.println(clock.getTimer());
    }
}
