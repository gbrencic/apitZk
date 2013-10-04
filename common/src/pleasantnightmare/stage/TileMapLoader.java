package pleasantnightmare.stage;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.09.28
 * Time: 13:43:27
 * To change this template use File | Settings | File Templates.
 */
public class TileMapLoader {
    private TiledStageMap stageMap;
    private int mapSize = 200; //temp SAYNATI IY DEFINICIJE MAPE

    public TileMapLoader() {
    }

    //Todo dodati ime staze
    public void loadStage() {
        stageMap = new TiledStageMap(mapSize);

        loadTileImages();   //Mozda bude trebalo negdje drugdje zbog ucitavanja u runtine
        fillTileBase();
        //ucitaj ostalo smece koje e na tileu
    }

    private void loadTileImages() {
        int t = 0;
        try {
            //todo makar preuyeti iy resource managera 
            stageMap.addTile(t++, new Image("/temp/tile1.png"));
            stageMap.addTile(t++, new Image("/temp/rock1.png"));
            stageMap.addTile(t++, new Image("/temp/water1.png"));
        } catch (SlickException e) {
            System.out.println(e);
        }
    }


    private void fillTileBase() {
        int imageID = 0;
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                // tiles[x][y] = new Tile();    //todo dodati da preuyme iz filea

//temp
                stageMap.setTile(y, x, new Tile(y, x));

                if (y % 3 == 0 || x % 3 == 0)
                    imageID = 2;

                if (y == 0 || y == mapSize - 1 ||
                        x == 0 || x == mapSize - 1)
                    imageID = 1;

                Tile tile = stageMap.getTile(y, x);
                tile.setTileImageID(imageID);
                //tile.setIlluminationStrenght(255);

                imageID = 0;
//temp end
            }
        }

        //todo maknuti
         stageMap.getTile(10, 10).setIlluminationStrenght(255);   //Todo privjeriti koliko da se svijetlo pojavljuje
         stageMap.getTile(10, 10).setIlluminationRange(8);   //Todo privjeriti koliko da se svijetlo pojavljuje
         stageMap.getTile(10, 10).setLightCaster(true);
    }

    public TiledStageMap getStageMap() {
        return stageMap;
    }
}
