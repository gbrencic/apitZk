package zk_old.graphic;

import pleasantnightmare.movment.Coordinates;
import zk_old.stage.BaseMap;
import zk_old.stage.MapDimensions;

import javax.swing.*;
import java.awt.*;

/**
 * User: gbrencic
 * Date: 02.03.12.
 * Time: 14:21
 */
public class TextRenderer {
    private Dimension screenSize = new Dimension(30, 30);
    private JLabel mapScreen;
    private final String LINE_START = "<p style=\"padding:-4;\">";
    private final String LINE_END = "</p>";
    private int z = 0;

    public TextRenderer(JLabel gameScreen) {
        this.mapScreen = gameScreen;
    }

    public void drawMap(BaseMap map, Coordinates center) {
        // String mapGraphic = formMapGraphics(stage);
        String mapGraphic = formMapGraphicsAlwaysFullView(map, center);
        mapScreen.setText(mapGraphic);
    }


    private String formMapGraphicsAlwaysFullView(BaseMap map, Coordinates center) {
        StringBuilder stringBuilder = new StringBuilder().append("<html>");
        MapDimensions dimensions = map.getMapDimensions();

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
            stringBuilder.append(LINE_START);
            for (int x = beginX; x <= endX; x++) {
                stringBuilder.append(map.getTileAt(z, x, y).getGraphic());
            }
            stringBuilder.append(LINE_END);
        }
        return stringBuilder.toString();
    }

    private String formMapGraphics(BaseMap map) {
        StringBuilder stringBuilder = new StringBuilder().append("<html>");
        MapDimensions dimensions = map.getMapDimensions();

        for (int y = 0; y <= dimensions.getY(); y++) {
            stringBuilder.append(LINE_START);
            for (int x = 0; x <= dimensions.getX(); x++) {
                stringBuilder.append(map.getTileAt(z, x, y).getGraphic());
            }
            stringBuilder.append(LINE_END);
        }
        return stringBuilder.toString();
    }


    private String formMapGraphics(BaseMap map, Coordinates center) {
        StringBuilder stringBuilder = new StringBuilder().append("<html>");
        MapDimensions dimensions = map.getMapDimensions();

        int beginX = center.getX() - (screenSize.width / 2);
        if (beginX < 0) beginX = 0;

        int endX = center.getX() + (screenSize.width / 2);
        if (endX > map.getMapDimensions().getX()) endX = map.getMapDimensions().getX();

        int beginY = center.getY() - (screenSize.height / 2);
        if (beginY < 0) beginY = 0;

        int endY = center.getY() + (screenSize.width / 2);
        if (endY > map.getMapDimensions().getY()) endY = map.getMapDimensions().getY();

        for (int y = beginY; y <= endY; y++) {
            stringBuilder.append(LINE_START);
            for (int x = beginX; x <= endX; x++) {
                stringBuilder.append(map.getTileAt(z, x, y).getGraphic());
            }
            stringBuilder.append(LINE_END);
        }
        return stringBuilder.toString();
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
}
