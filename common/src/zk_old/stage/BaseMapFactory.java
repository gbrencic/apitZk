package zk_old.stage;

import zk_old.entity.inanimate.FloorWall;
import zk_old.entity.inanimate.Tree;
import pleasantnightmare.movment.Coordinates;

import java.util.Random;

/**
 * User: gbrencic
 * Date: 22.03.12.
 * Time: 11:36
 */
public class BaseMapFactory {

    public static BaseMap getSquareMap(MapDimensions dimensions) {
        System.out.println("Creating square map...");
        BaseMap map = new BaseMap(dimensions);

        final int dimensionY = dimensions.getY();
        final int dimensionX = dimensions.getX();
        final int dimensionZ = dimensions.getZ();

        for (int z = 0; z <= dimensionZ; z++) {
            for (int y = 0; y <= dimensionY; y++) {
                for (int x = 0; x <= dimensionX; x++) {
                    final Coordinates coordinates = new Coordinates(z, x, y);
                    if (y == 0 || x == 0 || y == dimensionY || x == dimensionX) { //Ako je rubni tile
                        map.setTile(getEndStageTile(coordinates));
                    } else if (x <= dimensionX && y <= dimensionY && z == 0) {              //Ako je unutrašnji tile
                        map.setTile(getFloorTile(coordinates));
                    } else if (x <= dimensionX && y <= dimensionY && z > 0) {               //Ako je unutrašnji tile viši nivo
                        map.setTile(getEmptyTile(coordinates));
                    }
                }
            }
        }
        return map;
    }

    public static BaseMap addHill(BaseMap map, Stage stage) {
        System.out.println("Adding Hill...");
        Coordinates coordinates = new Coordinates(0, 6, 6);
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                coordinates.setX(coordinates.getX() + 1);
                map.getTileAt(coordinates).setMainEntity(new FloorWall(coordinates));
            }
            coordinates.setY(coordinates.getY() + 1);
            coordinates.setX(6);
        }

        coordinates = new Coordinates(1, 7, 7);
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                coordinates.setX(coordinates.getX() + 1);
                stage.addEntityBeforeUpdate(new FloorWall(coordinates));
            }
            coordinates.setY(coordinates.getY() + 1);
            coordinates.setX(7);
        }
        return map;
    }

    public static BaseMap addTrees(BaseMap map, Stage stage) {
        System.out.println("Adding Trees...");

        MapDimensions dimensions = map.getMapDimensions();
        final int dimensionY = dimensions.getY();
        final int dimensionX = dimensions.getX();

        for (int y = 0; y <= dimensionY; y++) {
            for (int x = 0; x <= dimensionX; x++) {
                int random = new Random().nextInt(20);
                if (random < 2) {
                    stage.addEntityBeforeUpdate(new Tree(new Coordinates(0, x, y)));
                }
            }
        }

        return map;
    }

    public static MapTile getEndStageTile(Coordinates coordinates) {
        return new MapTile(TextGraphics.WALL, true, coordinates);
    }

    public static MapTile getFloorTile(Coordinates coordinates) {
        return new MapTile(TextGraphics.FLOOR, false, coordinates);
    }

    public static MapTile getEmptyTile(Coordinates coordinates) {
        return new MapTile(TextGraphics.EMPTY, false, coordinates);
    }
}
