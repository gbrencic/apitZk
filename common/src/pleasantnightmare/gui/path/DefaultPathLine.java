package pleasantnightmare.gui.path;

import pleasantnightmare.entity.Body;
import pleasantnightmare.entity.BasicRoles;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.06.04
 * Time: 10:58:18
 * To change this template use File | Settings | File Templates.
 */
public class DefaultPathLine extends Body implements PathLine {
    private Line line;
    private Body start;
    private Body end;

    public DefaultPathLine(String id, Body start, Body end) {
        super(id, BasicRoles.GUICOMPONENT);
        this.start = start;
        this.end = end;
        line = new Line(start.getPosX(), start.getPosY(), end.getPosX(), end.getPosY());
    }

    public void update(StateBasedGame game, int delta) {
        line.set(start.getPosX(), start.getPosY(), end.getPosX(), end.getPosY());
    }

    public void render(StateBasedGame game, Graphics g) {
        g.draw(line);
    }
}
