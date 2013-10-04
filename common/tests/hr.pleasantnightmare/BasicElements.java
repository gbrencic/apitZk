package pleasantnightmare;

import pleasantnightmare.mouse.MousePointer;
import pleasantnightmare.mouse.SimpleMousePointer;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.MouseOverArea;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.03.27
 * Time: 13:43:48
 * To change this template use File | Settings | File Templates.
 */
public class BasicElements extends BasicGame {
    private GameContainer gameContainer;

    private MousePointer mousePointer;

    private MouseOverArea moa;
    

    public BasicElements() {
        super("Basic Elements Test");
    }

    public void init(GameContainer gameContainer) throws SlickException {
        this.gameContainer = gameContainer;

        moa = new MouseOverArea(gameContainer, new Image("area_1.png"), 10, 10);
        moa.setMouseOverImage(new Image("area_2.png"));
        moa.setMouseDownImage(new Image("area_3.png"));

        //(MouseOverArea, TextField, etc)
        // gui button http://slick.javaunlimited.net/viewtopic.php?t=851&highlight=mouseoverarea
        mousePointer = new SimpleMousePointer();
    }

    public void update(GameContainer gameContainer, int delta) throws SlickException {
        mousePointer.update(gameContainer, delta);
        //System.out.println(moa.isMouseOver()); //radi

    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        moa.render(gameContainer, graphics);
        mousePointer.reneder(gameContainer, graphics);
    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_ESCAPE) {
            gameContainer.exit();
        }
     }
        /*      if (key == Input.MOUSE_LEFT_BUTTON) {
     //moa.mousePressed(Input.MOUSE_LEFT_BUTTON,mousePointer.getX(gameContainer),mousePointer.getY(gameContainer));        }
        }*/


    public void mousePressed(int i, int i1, int i2) {
        moa.mousePressed(Input.MOUSE_LEFT_BUTTON, mousePointer.getX(gameContainer), mousePointer.getY(gameContainer));
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new BasicElements());
            container.setDisplayMode(800, 600, false);
            container.setMouseGrabbed(true);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
