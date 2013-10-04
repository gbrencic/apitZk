package hr.zk.junkyard;

/**
 * User: gbrencic
 * Date: 23.08.12.
 * Time: 08:40
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[][] map = new int[10000][10000];
        int[][] map2 = new int[10000][10000];
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map.length; y++) {
                map[x][y] = 1;
            }
        }

        for (int x = 0; x < map2.length; x++) {
            for (int y = 0; y < map2.length; y++) {
                map2[x][y] = 1;
            }
        }
    }
}
