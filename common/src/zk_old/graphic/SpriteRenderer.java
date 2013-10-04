package zk_old.graphic;

import pleasantnightmare.movment.Coordinates;
import zk_old.stage.BaseMap;
import zk_old.stage.MapDimensions;
import zk_old.stage.TextGraphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.ImageBuffer;

import java.awt.*;

/**
 * User: gbrencic
 * Date: 02.03.12.
 * Time: 14:21
 */
public class SpriteRenderer {//TODO ...
    private Dimension screenSize = new Dimension(200, 200);
    private int z = 0;
    private Image image;

    public SpriteRenderer() {
    }

    public void drawMap(BaseMap map, Coordinates center) {
        image = formMapGraphicsAlwaysFullView(map, center);
    }


    private Image formMapGraphicsAlwaysFullView(BaseMap map, Coordinates center) {
        MapDimensions dimensions = map.getMapDimensions();
        ImageBuffer buffer = new ImageBuffer(dimensions.getX(), dimensions.getY());
        z = getZLevel(map.getMapDimensions().getZ());

        int beginX = center.getX() - (screenSize.width / 2);
        if (beginX < 0) beginX = 0;

        int endX = beginX + screenSize.width;
        if (endX > dimensions.getX()) endX = dimensions.getX();

        int beginY = center.getY() - (screenSize.height / 2);
        if (beginY < 0) beginY = 0;

        int endY = beginY + screenSize.height;
        if (endY > dimensions.getY()) endY = dimensions.getY();

        for (int y = beginY; y <= endY; y++) {
            for (int x = beginX; x <= endX; x++) {
                String graphic = map.getTileAt(z, x, y).getGraphic();

                if (graphic.equals(TextGraphics.PLAYER)) {
                    buffer.setRGBA(x, y, 255, 255, 255, 255);
                } else if (graphic.equals(TextGraphics.SUN)) {
                    buffer.setRGBA(x, y, 255, 150, 150, 255);
                } else if (graphic.equals(TextGraphics.WALL)) {
                    buffer.setRGBA(x, y, 100, 100, 100, 255);
                } else if (graphic.equals(TextGraphics.FLOOR)) {
                    buffer.setRGBA(x, y, 0, 200, 0, 255);
                } else if (graphic.equals(TextGraphics.EMPTY)) {
                    buffer.setRGBA(x, y, 255, 255, 255, 255);
                } else if (graphic.equals(TextGraphics.TREE)) {
                    buffer.setRGBA(x, y, 0, 255, 50, 255);
                } else if (graphic.equals(TextGraphics.BOMB)) {
                    buffer.setRGBA(x, y, 200, 250, 250, 255);
                } else if (graphic.equals(TextGraphics.BULLET)) {
                    buffer.setRGBA(x, y, 255, 200, 200, 255);
                } else if (graphic.equals(TextGraphics.FIRE_LARGE)) {
                    buffer.setRGBA(x, y, 255, 200, 200, 255);
                } else if (graphic.equals(TextGraphics.FIRE_SMALL)) {
                    buffer.setRGBA(x, y, 200, 100, 100, 255);
                } else if (graphic.equals(TextGraphics.ENEMY)) {
                    buffer.setRGBA(x, y, 0, 0, 0, 255);
                } else if (graphic.equals(TextGraphics.SPAWN_POINT)) {
                    buffer.setRGBA(x, y, 100, 100, 255, 255);
                } else {
                    System.out.println("Unknown Graphic! : " + graphic);
                }
            }
        }
        return buffer.getImage();
    }

    public void riseLevelToRender() {
        z++;
    }

    public void lowerLevelToRender() {
        z--;
        if (z < 0)
            z = 0;
    }

    public int getZLevel(int maxZ) {
        if (z > maxZ)
            z = maxZ;
        return z;
    }

    public Image getImage() {
        return image;
    }
}
