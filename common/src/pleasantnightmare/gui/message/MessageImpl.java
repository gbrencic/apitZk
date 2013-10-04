package pleasantnightmare.gui.message;

import pleasantnightmare.entity.Body;
import pleasantnightmare.entity.BasicRoles;
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
public class MessageImpl extends Body implements Message {
    private String title;
    private String text;

    private int width;
    private int height;

    private Rectangle header;
    private Rectangle textField;

    public MessageImpl(String id, float posX, float posY, int width, int height,  String title, String text) {
        super(id, posX, posY, BasicRoles.GUICOMPONENT);
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
