package hr.zk.common.gui.button;

import hr.zk.common.Animatable;
import hr.zk.common.entity.DefaultEntity;
import hr.zk.common.entity.DefaultRoles;
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
 */
public class SlickMutedButton extends DefaultEntity implements Button, Animatable {
    private Image up, down;
    private float width, height;
    private float startWidth, startHeight;

    private boolean mouseInside, mouseDown;
    private ClickListener listener;

    private Object userData;

    public SlickMutedButton(Long id, String name, float x, float y, Image u, Image d) throws SlickException {
        super(id, name, x, y, DefaultRoles.GUICOMPONENT);
        up = u;
        down = d;
//        down.setAlpha(0f);

        width = u.getWidth();
        height = u.getHeight();
        startWidth = width;
        startHeight = height;
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
        float x = getPosX();
        float y = getPosY();
        up.draw(x, y, width, height);
        down.draw(x, y, width, height);
    }

    public void update(StateBasedGame game, int delta) {
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
                onMouseEnter();
            }
        } else {
            if (mouseInside) {
                mouseInside = false;
                onMouseExit();
            }
        }
        if (pressed && !mouseDown && mouseInside) {
            mouseDown = true;
            press();
            listener.onClick(game, this);
        } else if (!pressed && mouseDown) {
            mouseDown = false;
        }
    }

    public void press() {

    }

    public void onMouseEnter() {
        down.setAlpha(1f);
    }

    public void onMouseExit() {
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