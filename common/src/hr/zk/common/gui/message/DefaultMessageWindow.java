package hr.zk.common.gui.message;

import hr.zk.common.entity.DefaultEntity;
import hr.zk.common.entity.DefaultRoles;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.22
 * Time: 12:01:45
 * To change this template use File | Settings | File Templates.
 */
public class DefaultMessageWindow extends DefaultEntity implements Message {
    private String title;
    private String text;

    private int width;
    private int height;

    private Rectangle header;
    private Rectangle textField;

    public DefaultMessageWindow(Long id, String name, float posX, float posY, int width, int height, String title, String text) {
        super(id, name, posX, posY, DefaultRoles.GUICOMPONENT);
        this.title = title;
        this.text = text;
        this.width = width;
        this.height = height;

        header = new Rectangle(posX, posY, width, 25);
        textField = new Rectangle(posX, posY + 25, width, height);

        formatText();
    }


    public void update(StateBasedGame entity, int delta) {

    }

    public void render(StateBasedGame entity, Graphics g) {
        g.draw(header);
        g.drawString(title, header.getX(), header.getY());
        g.draw(textField);
        g.drawString(text, textField.getX() + 5, textField.getY());
    }

    private void formatText() {
        int charactersPerRow = (width) / 10;
        //text = UtilitiesText.formatTextToBlock(text, charactersPerRow);
        //todo fix
    }
}
