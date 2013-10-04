package zk_old.stage;

import pleasantnightmare.movment.Coordinates;

/**
 * User: gbrencic
 * Date: 22.03.12.
 * Time: 10:09
 */
public class BaseMap {
    private final MapTile[][][] mapTiles;
    private final MapDimensions mapDimensions;

    public BaseMap(MapDimensions mapDimensions) {
        this.mapDimensions = mapDimensions;
        mapTiles = new MapTile[mapDimensions.getZ() + 1][mapDimensions.getX() + 1][mapDimensions.getY() + 1];
    }

    public MapDimensions getMapDimensions() {
        return mapDimensions;
    }

    public MapTile getTileAt(int z, int x, int y) {
        MapTile mapTile = null;
        try {
            mapTile = mapTiles[z][x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return mapTile;
    }

    public MapTile getTileAt(Coordinates coordinates) {
        if (!mapContainsCoordinates(coordinates))
            return MapTile.getNullTile();     //Rise warn
        return getTileAt(coordinates.getZ(), coordinates.getX(), coordinates.getY());
    }

    public void setTile(MapTile tile) {
        Coordinates c = tile.getCoordinates();
        mapTiles[c.getZ()][c.getX()][c.getY()] = tile;
    }

    public boolean mapContainsCoordinates(Coordinates coordinates) {
        if (coordinates.getX() < 0 || coordinates.getX() > mapDimensions.getX())
            return false;//  throw new IllegalArgumentException("Out of bounds X! " + coordinates.toString());

        if (coordinates.getY() < 0 || coordinates.getY() > mapDimensions.getY())
            return false;//throw new IllegalArgumentException("Out of bounds Y! " + coordinates.toString());

        if (coordinates.getZ() < 0 || coordinates.getZ() > mapDimensions.getZ())
            return false;//throw new IllegalArgumentException("Out of bounds Z! " + coordinates.toString());

        return true;
    }

    public void endTurnUpdate() {

    }
}
