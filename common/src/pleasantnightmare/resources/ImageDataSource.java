package pleasantnightmare.resources;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.14
 * Time: 13:41:56
 * To change this template use File | Settings | File Templates.
 */
public interface ImageDataSource {
    void loadPackedSpriteSheet(String packedSheetName, String[] imageNames) throws SlickException;

    void registerImage(String imageName, Image image);

    void registerImage(String imageId, String imageName);

    Image get(String imageName);

    Image unregister(String imageName);

    boolean hasResource(String imageName);

    void clearImages();
}
