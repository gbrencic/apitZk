package pleasantnightmare.stage;

import pleasantnightmare.colors.DayNightColors;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;


/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.09.23
 * Time: 10:15:19
 * To change this template use File | Settings | File Templates.
 */
public class TileMapRenderer {
    private TiledStageMap stageMap;
    private Rectangle viewBoundry;     //temp;
    private int posX = 20;             //Position on the screen;
    private int posY = 20;
    private int width = 500;           //VieportSize;
    private int height = 500;
    private int viewTileWidth = 1;     //How many tiles can be displayed on the map W / H;

    private int viewCenterPosX = 0;   //Position on the map;
    private int viewCenterPosY = 0;

    private Rectangle tile; //map tile    //todo temp;

    private TiledMapLightninghCalculator tileMapLightninghCalculator;
    private MapRenderPosition mapRenderPosition = new MapRenderPosition();

    public TileMapRenderer(TiledStageMap stageMap) {
        this.stageMap = stageMap;
        viewBoundry = new Rectangle(posX, posY, width, height);  //For testing purposes
        tile = new Rectangle(0, 0, stageMap.getTileSize(), stageMap.getTileSize());

        viewTileWidth = (int) viewBoundry.getWidth() / stageMap.getTileSize();
        tileMapLightninghCalculator = new TiledMapLightninghCalculator(stageMap);
        mapRenderPosition.calculate();
    }

    public void update(GameContainer gc, int delta) {
        // mapRenderPosition.calculate();
        /*   tileMapLightninghCalculator.calculateLight(mapRenderPosition.startY,
        mapRenderPosition.endY,
        mapRenderPosition.startX,
        mapRenderPosition.endX);
        */
    }


    public void renderMap(Graphics graphics) {
        //TODO optimizirati varijable
        //Calculate min tile to display
        Image tempTile;
        int startX = (viewCenterPosX - posX) / stageMap.getTileSize() * -1;
        if (startX < 0)
            startX = 0;

        if (startX > stageMap.getMapSize())
            startX = stageMap.getMapSize();

        int startY = (viewCenterPosY - posY) / stageMap.getTileSize() * -1;
        if (startY < 0)
            startY = 0;

        if (startY > stageMap.getMapSize())
            startY = stageMap.getMapSize();

        //Calculate max tile to display
        int endX = startX + viewTileWidth + 2;
        if (endX > stageMap.getMapSize())
            endX = stageMap.getMapSize();

        int endY = startY + viewTileWidth + 2;
        if (endY > stageMap.getMapSize())
            endY = stageMap.getMapSize();

        //   Image graphicTile = stageMap.getTile(0);
        //  int frame = 0;
        //  float alfa = 0; // Dobro za objekte preko playera
        // draw(x,y,color)  // dobro LOS
        //TOdo izvuci svijetlo vani
        float colorHue = 1;
        tileMapLightninghCalculator.calculateLight(startY, endY, startX, endX);
        Color color = DayNightColors.night;
      //  color = Color.white;
        for (int y = startY; y < endY; y++) {
            tile.setY(y * stageMap.getTileSize() + viewCenterPosY);

            for (int x = startX; x < endX; x++) {
                tile.setX(x * stageMap.getTileSize() + viewCenterPosX);

                tempTile = stageMap.getTileImage(stageMap.getTile(y, x).getTileImageID());
                //  tempTile.draw(tile.getX(), tile.getY(), color);
                //Todo uvrstiti prikaz bojew koju prikazuje
                tempTile.draw(tile.getX(), tile.getY(), color.brighter(stageMap.getTile(y, x).getIlluminationStrenght()));
            }
        }
    }

    //Todo izvuci vani ako se koristi jos negdje
    private class MapRenderPosition {
        public int startX = 20;
        public int endX;
        public int startY;
        public int endY;

        public void calculate() {
            int startX = (viewCenterPosX - posX) / stageMap.getTileSize() * -1;
            if (startX < 0)
                startX = 0;

            if (startX > stageMap.getMapSize())
                startX = stageMap.getMapSize();

            int startY = (viewCenterPosY - posY) / stageMap.getTileSize() * -1;
            if (startY < 0)
                startY = 0;

            if (startY > stageMap.getMapSize())
                startY = stageMap.getMapSize();

            //Calculate max tile to display
            int endX = startX + viewTileWidth + 2;
            if (endX > stageMap.getMapSize())
                endX = stageMap.getMapSize();

            int endY = startY + viewTileWidth + 2;
            if (endY > stageMap.getMapSize())
                endY = stageMap.getMapSize();

        }
    }

    public Rectangle getViewBoundry() {
        return viewBoundry;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SquaredMap getStageMap() {
        return stageMap;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setViewCenterPosX(int viewCenterPosX) {
        this.viewCenterPosX = viewCenterPosX;
    }

    public void setViewCenterPosY(int viewCenterPosY) {
        this.viewCenterPosY = viewCenterPosY;
    }

    public int getViewCenterPosX() {
        return viewCenterPosX;
    }

    public int getViewCenterPosY() {
        return viewCenterPosY;
    }
}
