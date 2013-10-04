package pleasantnightmare.gui.progressbar;

import pleasantnightmare.entity.BasicRoles;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.06.01
 * Time: 13:08:35
 * To change this template use File | Settings | File Templates.
 */
public class GraphicalProgressBar extends AbstractProgressBarImpl {
    private Image fullIcon;
    private Image emptyIcon;
    private float spacer = 0;

    public GraphicalProgressBar(String id, int posX, int posY, float minValue, float maxValue, float currentValue, Image fullIcon, Image emptyIcon, float spacer) {
        super(id, posX, posY, BasicRoles.GUICOMPONENT, minValue, maxValue, currentValue);
        this.fullIcon = fullIcon;
        this.emptyIcon = emptyIcon;
        this.spacer = spacer + fullIcon.getWidth();
    }

    public void update(StateBasedGame game, int delta) {
        //TODO Implement ME
    }

    public void render(StateBasedGame game, Graphics g) {
        for (float i = 0; i <= getMaxValue(); i++) {
            if (i < getCurrentValue())
                fullIcon.draw(getPosX() + (spacer * i), getPosY());
            else
                emptyIcon.draw(getPosX() + (spacer * i), getPosY());
        }
    }
}
