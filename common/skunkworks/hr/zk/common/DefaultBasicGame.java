package hr.zk.common;

import org.newdawn.slick.*;

/**
 * User: gbrencic
 * Date: 04.10.13.
 * Time: 11:50
 */
public class DefaultBasicGame extends BasicGame {
    private GameContainer gameContainer;

    public DefaultBasicGame() {
        super("Default...");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.gameContainer = gameContainer;
        //Load resources
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        //TODO Implement ME
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        //TODO Implement ME
    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_ESCAPE) {
            gameContainer.exit();
        }
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new DefaultBasicGame());
            container.setDisplayMode(800, 600, false);
            container.setMouseGrabbed(true);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
