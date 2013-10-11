package hr.zk.common;

import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Graphics;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.14
 * Time: 13:20:05
 * To change this template use File | Settings | File Templates.
 */
public interface Animatable {
    public void update(StateBasedGame game, int delta);

    public void render(StateBasedGame game, Graphics g);
}
