package pleasantnightmare.gui.button;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import pleasantnightmare.entity.BasicRoles;
import pleasantnightmare.entity.Body;
import pleasantnightmare.graphics.Animatable;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.14
 * Time: 13:19:34
 * To change this template use File | Settings | File Templates.
 */
public class SlickButton extends Body implements Button, Animatable {
    private static Sound click, hover;

    private Image up, down;
    private float width, height;
    private float startWidth, startHeight;

    private boolean mouseInside, mouseDown;
    private ClickListener listener;

    private Object userData;

    static {
        try {
            click = new Sound("states/common/click.ogg");
            hover = new Sound("states/common/hover.ogg");
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public SlickButton(String id, float x, float y, Image u, Image d) throws SlickException {
        super(id, x, y, BasicRoles.GUICOMPONENT);
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
        click.play();
    }

    public void onMouseEnter() {
        hover.play();
    }

    public void onMouseExit() {
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
