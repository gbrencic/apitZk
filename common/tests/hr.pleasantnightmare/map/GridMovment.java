package hr.pleasantnightmare.map;

import org.newdawn.slick.*;

/**
 * User: gbrencic
 * Date: 31.08.12.
 * Time: 13:14
 */
public class GridMovment extends BasicGame {
    private static int GRID_SIZE = 32;
    private GameContainer gameContainer;
    private GridMover gridMover;

    public GridMovment() {
        super("Map v0.1");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.gameContainer = gameContainer;
        gridMover = new GridMover(4, 4, GRID_SIZE);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        gridMover.update(delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        //Draw grid
        graphics.setColor(Color.darkGray);
        for (int x = 0; x < 27; x++) {
            graphics.drawLine(x * GRID_SIZE, 0, x * GRID_SIZE, 600);
        }
        for (int y = 0; y < 20; y++) {
            graphics.drawLine(0, y * GRID_SIZE, 800, y * GRID_SIZE);
        }

        graphics.setColor(Color.blue);
        graphics.draw(gridMover.getShape());
    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_ESCAPE) {
            gameContainer.exit();
        }

        if (key == Input.KEY_ENTER) {
            gridMover.moveRight();
        }
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new GridMovment());
            container.setDisplayMode(800, 600, false);
            container.setMouseGrabbed(false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
