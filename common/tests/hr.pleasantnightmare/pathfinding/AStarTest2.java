package hr.pleasantnightmare.pathfinding;

import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;


public class AStarTest2 {

    private static final int MAX_PATH_LENGTH = 100;

    private static final int START_X = 5;
    private static final int START_Y = 1;

    private static final int GOAL_X = 5;
    private static final int GOAL_Y = 8;

    public static void main(String[] args) {

        SimpleMap2 map = new SimpleMap2();
        int[][] mapPath = map.getMap();

        AStarPathFinder pathFinder = new AStarPathFinder(map, MAX_PATH_LENGTH, true);
        Path path = pathFinder.findPath(null, START_X, START_Y, GOAL_X, GOAL_Y);         //Null for no path

        //path.getStep()moze uzeti stepove...

        if (null != path) {
            int length = path.getLength();
            System.out.println("Found path of length: " + length + ".");

            for (int i = 0; i < length; i++) {
                System.out.println("Move to: " + path.getX(i) + "," + path.getY(i) + ".");
                mapPath[path.getX(i)][path.getY(i)] = 8;
            }
        }


//        mapPath = map.getMap2();

        mapPath[START_X][START_Y] = 2;
        mapPath[GOAL_X][GOAL_Y] = 3;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.print(mapPath[x][y]);
            }
            System.out.println("");
        }
    }

}


class SimpleMap2 implements TileBasedMap {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private static final int[][] MAP = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };

    private static final int[][] MAP2 = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };

    @Override
    public boolean blocked(PathFindingContext ctx, int x, int y) {
        if (MAP[y][x] == 0)
            MAP2[x][y] = MAP2[x][y] + 1;
        return MAP[y][x] != 0;
    }

    @Override
    public float getCost(PathFindingContext ctx, int x, int y) {
        return 1.0f;
    }

    @Override
    public int getHeightInTiles() {
        return HEIGHT;
    }

    @Override
    public int getWidthInTiles() {
        return WIDTH;
    }

    @Override
    public void pathFinderVisited(int x, int y) {
    }

    public static int[][] getMap() {
        return MAP;
    }

    public static int[][] getMap2() {
        return MAP2;
    }
}


