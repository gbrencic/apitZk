package hr.pleasantnightmare.network.simplegame.util;

/**
 * User: gbrencic
 * Date: 30.08.12.
 * Time: 15:05
 */
public class IdProvider {
    private static int id = 0;

    public static synchronized int getNextId() {
        id = id + 1;
        return id;
    }
}
