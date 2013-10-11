package hr.zk.junkyard;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

/**
 * User: gbrencic
 * Date: 04.10.13.
 * Time: 11:50
 */
public class DeltaMovment extends BasicGame {
    private GameContainer gameContainer;
    private Rectangle rectangle = new Rectangle(0, 0, 32, 32);
    private Vector2f position = new Vector2f(0f, 0f);
    private Vector2f speed = new Vector2f(50, 50);

    public DeltaMovment() {
        super("DeltaMovment...");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.gameContainer = gameContainer;
        //Load resources
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        Vector2f realSpeed = speed.copy();
        realSpeed.scale((delta / 1000.0f));

        position.add(realSpeed);
        rectangle.setX(position.x);
        rectangle.setY(position.y);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        graphics.draw(rectangle);
        graphics.drawString(String.valueOf(speed.getTheta()), 50, 50);
    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_ESCAPE) {
            gameContainer.exit();
        }
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new DeltaMovment());
            container.setDisplayMode(800, 600, false);
            container.setMouseGrabbed(true);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
