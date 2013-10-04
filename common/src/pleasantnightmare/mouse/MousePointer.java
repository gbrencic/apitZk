package pleasantnightmare.mouse;

import pleasantnightmare.Updetable;
import pleasantnightmare.Drawable;
import org.newdawn.slick.GameContainer;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.03.27
 * Time: 14:15:03
 * To change this template use File | Settings | File Templates.
 */
public interface MousePointer extends Updetable, Drawable {

    int getX(GameContainer gc);

    int getY(GameContainer gc);
}
