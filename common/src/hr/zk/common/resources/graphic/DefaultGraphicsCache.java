package hr.zk.common.resources.graphic;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.PackedSpriteSheet;
import org.newdawn.slick.SpriteSheet;

import java.util.HashMap;
import java.util.Map;

/**
 * User: gbrencic
 * Date: 04.10.13.
 * Time: 12:25
 */
final class DefaultGraphicsCache implements GraphicsCache {
    private final Map<String, PackedSpriteSheet> packedSpriteSheetMap = new HashMap<String, PackedSpriteSheet>();
    private final Map<String, SpriteSheet> spriteSheetMap = new HashMap<String, SpriteSheet>();
    private final Map<String, Image> imageMap = new HashMap<String, Image>();
    private final Map<String, Animation> animationMap = new HashMap<String, Animation>();

    @Override
    public boolean doesNotContainPackedSpriteSheet(String packedSheetName) {
        return !packedSpriteSheetMap.containsKey(packedSheetName);
    }

    @Override
    public void addPackedSpriteSheet(String packedSheetName, PackedSpriteSheet packedSpriteSheet) {
        packedSpriteSheetMap.put(packedSheetName, packedSpriteSheet);
    }

    @Override
    public PackedSpriteSheet getPackedSpriteSheet(String packedSheetName) {
        return packedSpriteSheetMap.get(packedSheetName);
    }

    @Override
    public boolean doesNotContainSpriteSheet(String sheetName) {
        return !spriteSheetMap.containsKey(sheetName);
    }

    @Override
    public void addSpriteSheet(String sheetName, SpriteSheet spriteSheet) {
        spriteSheetMap.put(sheetName, spriteSheet);
    }

    @Override
    public SpriteSheet getSpriteSheet(String sheetName) {
        return spriteSheetMap.get(sheetName);
    }

    @Override
    public boolean doesNotComtainImage(String imageName) {
        return !imageMap.containsKey(imageName);
    }

    @Override
    public void addImage(String imageName, Image image) {
        imageMap.put(imageName, image);
    }

    @Override
    public Image getImage(String imageName) {
        return imageMap.get(imageName);
    }

    @Override
    public boolean containsAnimation(String animationName) {
        return animationMap.containsKey(animationName);
    }

    @Override
    public void addAnimation(String animationName, Animation animation) {
        animationMap.put(animationName, animation);
    }

    @Override
    public Animation getAnimation(String animationName) {
        return animationMap.get(animationName);
    }

    @Override
    public void clearAll() {
        packedSpriteSheetMap.clear();
        spriteSheetMap.clear();
        imageMap.clear();
        animationMap.clear();
    }
}
