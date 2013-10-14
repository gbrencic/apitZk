package hr.zk.common.resources.graphic;

import hr.zk.common.resources.ResourceNotFoundException;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.PackedSpriteSheet;
import org.newdawn.slick.SpriteSheet;

/**
 * User: gbrencic
 * Date: 04.10.13.
 * Time: 11:57
 */
public interface GraphicsLoader {
    void loadPackedSpriteSheet(String packedSheetName) throws ResourceNotFoundException;

    PackedSpriteSheet getPackedSpriteSheet(String packedSheetName) throws ResourceNotFoundException;

    void loadSpriteSheet(String spriteSheetImageName, int width, int height) throws ResourceNotFoundException;

    SpriteSheet getSpriteSheet(String spriteSheetImageName) throws ResourceNotFoundException;

    SpriteSheet getSpriteSheet(String packedSheetName, String spriteSheetImageName) throws ResourceNotFoundException;

    void loadImage(String imageName) throws ResourceNotFoundException;

    Image getImage(String imageName) throws ResourceNotFoundException;

    void loadAnimation(String animationName, String packedSheetName, String spriteSheet, int rows, int columns, int speed);

    void loadHorizontaliyFlippedAnimation(String animationName, String packedSheetName, String spriteSheet, int rows, int columns, int speed);

    Animation getAnimation(String animationName);
}
