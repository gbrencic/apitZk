package pleasantnightmare.mouse;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.03.27
 * Time: 13:57:48
 * To change this template use File | Settings | File Templates.
 */
public class SimpleMousePointer implements MousePointer {
    Image pointer;

    public SimpleMousePointer() {
        try {
            this.pointer = new Image("default_cursor.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public SimpleMousePointer(Image pointer) {
        this.pointer = pointer;
    }

    public void update(GameContainer gc, int delta) {

    }

    public void reneder(GameContainer gc, Graphics graphics) {
        graphics.drawImage(pointer, gc.getInput().getMouseX(), gc.getInput().getMouseY());
    }

   public int getX(GameContainer gc) {
      return gc.getInput().getMouseX();
   }

    public int getY(GameContainer gc) {
     return gc.getInput().getMouseY(); 
   }
}
