package hr.zk.common.resources.graphic;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.PackedSpriteSheet;
import org.newdawn.slick.SpriteSheet;

/**
 * User: gbrencic
 * Date: 04.10.13.
 * Time: 12:21
 */
public interface GraphicsCache {
    boolean doesNotContainPackedSpriteSheet(String packedSheetName);

    void addPackedSpriteSheet(String packedSheetName, PackedSpriteSheet packedSpriteSheet);

    PackedSpriteSheet getPackedSpriteSheet(String packedSheetName);

    boolean doesNotContainSpriteSheet(String sheetName);

    void addSpriteSheet(String sheetName, SpriteSheet spriteSheet);

    SpriteSheet getSpriteSheet(String sheetName);

    boolean doesNotComtainImage(String imageName);

    void addImage(String imageName, Image image);

    Image getImage(String imageName);

    boolean containsAnimation(String animationName);

    void addAnimation(String animationName, Animation animation);

    Animation getAnimation(String animationName);

    void clearAll();
}
