package hr.zk.common.gui.button;

import hr.zk.common.Animatable;
import hr.zk.common.entity.DefaultEntity;
import hr.zk.common.entity.DefaultRoles;
import hr.zk.common.util.time.Counter;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.14
 * Time: 13:19:34
 * To change this template use File | Settings | File Templates.
 */
public class TimedButton extends DefaultEntity implements Button, Animatable {
    private Image up, down;
    private float width, height;
    private float startWidth, startHeight;

    private boolean mouseInside, mouseDown;
    private ClickListener listener;

    private Object userData;

    private Counter counter;
    private boolean activated = false;


    public TimedButton(Long id, String name, float x, float y, Image u, Image d,int delay) throws SlickException {
        super(id, name, x, y, DefaultRoles.GUICOMPONENT);
        up = u;
        down = d;
        down.setAlpha(0f);

        width = u.getWidth();
        height = u.getHeight();
        startWidth = width;
        startHeight = height;
        initTimer(delay);
    }

    private void initTimer(int delay) {
        counter = new Counter(delay) {
            public void performAction() {
                activated = false;
            }
        };
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public void render(StateBasedGame game, Graphics g) {
        up.draw(getPosX(), getPosY(), width, height);
        down.draw(getPosX(), getPosY(), width, height);
    }

    public void update(StateBasedGame game, int delta) {
        if (activated) {
            counter.update(delta);
            return;
        }

        Input input = game.getContainer().getInput();
        int mx = input.getMouseX();
        int my = input.getMouseY();
        float x = getPosX();
        float y = getPosY();
        boolean pressed = input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON);

        if (mx >= x && mx <= x + width &&
                my >= y && my <= y + height) {
            if (!mouseInside) {
                mouseInside = true;
            }
        } else {
            if (mouseInside) {
                mouseInside = false;
            }
        }

        if (pressed && !mouseDown && mouseInside) {
            mouseDown = true;
            activated();
            listener.onClick(game, this);
        } else if (!pressed && mouseDown) {
            mouseDown = false;
            deactivated();
        }
    }

    public void press() {

    }

    public void activated() {
        activated = true;
        down.setAlpha(1f);
    }

    public void deactivated() {
        down.setAlpha(0f);
    }

    public void reset() {
    }

    public void addListener(ClickListener l) {
        listener = l;
    }

    public void setUserData(Object o) {
        userData = o;
    }

    public Object getUserData() {
        return userData;
    }
}