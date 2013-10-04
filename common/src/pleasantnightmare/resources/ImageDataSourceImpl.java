package pleasantnightmare.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.PackedSpriteSheet;
import org.newdawn.slick.SlickException;

import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.14
 * Time: 13:42:26
 * To change this template use File | Settings | File Templates.
 */
public class ImageDataSourceImpl implements ImageDataSource {
    private ConcurrentHashMap<String, Image> images = new ConcurrentHashMap<String, Image>();
    private Object applicationContext;

    public ImageDataSourceImpl() {
    }

    public void loadPackedSpriteSheet(String packedSheetName, String[] imageNames) throws SlickException {
        PackedSpriteSheet spriteSheet = new PackedSpriteSheet(packedSheetName + ".def", Image.FILTER_NEAREST);
        for (String imageName : imageNames) {
            try {
                registerImage(imageName, spriteSheet.getSprite(imageName));
            } catch (RuntimeException e) {
                throw new ResourceNotFoundException("Unknown sprite from packed sheet: " + imageName);
            }
        }
    }

    public void registerImage(String imageName, Image image) {
        if (!images.containsKey(imageName))
            images.put(imageName, image);
        return;
    }

    public void registerImage(String imageId, String imageName) {
        if (!images.containsKey(imageId))
            try {
                images.put(imageId, new Image(imageName));
            } catch (SlickException e) {
                throw new ResourceNotFoundException("Image not found: " + imageName);
            }
    }

    public Image get(String imageName) {
        if (!images.containsKey(imageName))
            throw new ResourceNotFoundException("Image not loaded: " + imageName);
        return images.get(imageName);
    }

    public Image unregister(String imageName) {
        if (!images.containsKey(imageName))
            throw new ResourceNotFoundException("Image not loaded: " + imageName);
        return images.remove(imageName);
    }

    public boolean hasResource(String imageName) {
        for (String s : images.keySet()) {
            System.out.println(s);
        }

        if (images.containsKey(imageName))
            return true;
        return false;
    }

    public void clearImages() {
        images.clear();
    }
}
