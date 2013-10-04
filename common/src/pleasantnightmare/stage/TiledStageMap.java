package pleasantnightmare.stage;

import org.newdawn.slick.Image;

/**
 * Keeps the map info
 */
public class TiledStageMap implements SquaredMap {
    private Image[] tilesImages;
    private int tileSize = 32;   //todo prebaciti u x i y
    private int mapSize = 0;   //todo prebaciti u x i y
    private int tileCount = 20; //Saznati koliko je tileova iz mape
    private Tile[][] tiles;

    public TiledStageMap(int mapSize) {
        this.mapSize = mapSize;
        tiles = new Tile[mapSize][mapSize];
        tilesImages = new Image[tileCount];
    }

    public void addTile(int index, Image image) {
        tilesImages[index] = image;
    }

    public Image getTileImage(int index) {
        //todo exception ako nema tile
        return tilesImages[index];
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Tile getTile(int y, int x) {
        return tiles[y][x];
    }

    public Tile setTile(int y, int x, Tile tile) {
        return tiles[y][x] = tile;
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getMapSize() {
        return mapSize;
    }
}