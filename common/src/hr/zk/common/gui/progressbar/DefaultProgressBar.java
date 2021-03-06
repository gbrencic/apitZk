package hr.zk.common.gui.progressbar;

import hr.zk.common.entity.DefaultRoles;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.21
 * Time: 14:08:13
 * To change this template use File | Settings | File Templates.
 */
public class DefaultProgressBar extends AbstractProgressBarImpl {
    private final float width;
    private final float height;
    private final Rectangle border;

    private final Rectangle fill;
    private final GradientFill bgFill;

    private int speed = 50;
    private float desiredWidth;
    private float currentWidth = 0;


    public DefaultProgressBar(Long id, String name, int posX, int posY, float width, float height, float minValue, float maxValue, float currentValue, int speed) {
        super(id, name, posX, posY, DefaultRoles.GUICOMPONENT, minValue, maxValue, currentValue);
        this.width = width;
        this.height = height;
        this.speed = speed;

        border = new Rectangle(posX - 1, posY, width + 1, height + 1);
        fill = new Rectangle(posX, posY, width, height);
        bgFill = new GradientFill(0, 0, Color.red, width, height, Color.green);
        calculateWidth();
    }

    public void render(StateBasedGame game, Graphics g) {
        g.draw(border);
        g.setColor(Color.red);
        g.fill(fill, bgFill);
        g.setColor(Color.white);
    }

    public void update(StateBasedGame game, int delta) {
        //TODO popravak da ne trza znaci ako je manji od speeda da ga ogranici i postavi na velicinu koja treba
        /*if (currentWidth >= desiredWidth)
            currentWidth = currentWidth - DeltaUtil.calculateDelta(delta, speed);
        else
            currentWidth = currentWidth + DeltaUtil.calculateDelta(delta, speed);
        fill.setWidth(currentWidth);*/
    }

    private void calculateWidth() {
        desiredWidth = (getPercentage() * width) / 100;
    }

    @Override
    public void setCurrentValue(float currentValue) {
        super.setCurrentValue(currentValue);
        calculateWidth();
    }
}
