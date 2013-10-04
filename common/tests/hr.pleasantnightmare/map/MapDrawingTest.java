package hr.pleasantnightmare.map;

import org.newdawn.slick.*;

/**
 * User: gbrencic
 * Date: 31.08.12.
 * Time: 13:14
 */
public class MapDrawingTest extends BasicGame {
    private Image grassTile;
    private GameContainer gameContainer;

    public MapDrawingTest() {
        super("Map v0.1");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.gameContainer = gameContainer;
        grassTile = new Image("common/resources/kev/grass.png");
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        //TODO Implement ME
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (int x = 0; x < 27; x++) {
            for (int y = 0; y < 20; y++) {
                graphics.drawImage(grassTile, 30 * x, 30 * y);
            }
        }
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new MapDrawingTest());
            container.setDisplayMode(800, 600, false);
            container.setMouseGrabbed(false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
