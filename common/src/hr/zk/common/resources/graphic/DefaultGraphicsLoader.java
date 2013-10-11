package hr.zk.common.resources.graphic;

import hr.zk.common.resources.ResourceNotFoundException;
import org.newdawn.slick.*;

/**
 * User: gbrencic
 * Date: 02.10.13.
 * Time: 12:13
 */
public final class DefaultGraphicsLoader implements GraphicsLoader {
    private final GraphicsCache graphicsCache;
    public final String imageDirectory;

    /**
     * @param imageDirectory - Use trailing slash
     */
    public DefaultGraphicsLoader(String imageDirectory, GraphicsCache graphicsCache) {
        this.imageDirectory = imageDirectory;
        this.graphicsCache = graphicsCache;
    }

    @Override
    public void loadPackedSpriteSheet(String packedSheetName) throws ResourceNotFoundException {
        try {
            if (graphicsCache.doesNotContainPackedSpriteSheet(packedSheetName))
                graphicsCache.addPackedSpriteSheet(packedSheetName, new PackedSpriteSheet(imageDirectory + packedSheetName + ".def", Image.FILTER_NEAREST));
        } catch (SlickException e) {
            throw new ResourceNotFoundException("Resource: Packed sprite sheet - " + packedSheetName + " NOT FOUND ", e);
        }
    }

    @Override
    public PackedSpriteSheet getPackedSpriteSheet(String packedSheetName) throws ResourceNotFoundException {
        if (graphicsCache.doesNotContainPackedSpriteSheet(packedSheetName))
            loadPackedSpriteSheet(packedSheetName);

        return graphicsCache.getPackedSpriteSheet(packedSheetName);
    }

    @Override
    public void loadSpriteSheet(String spriteSheetImageName, int width, int height) throws ResourceNotFoundException {
        try {
            if (graphicsCache.doesNotContainSpriteSheet(spriteSheetImageName))
                graphicsCache.addSpriteSheet(spriteSheetImageName, new SpriteSheet(imageDirectory + spriteSheetImageName, width, height));
        } catch (SlickException e) {
            throw new ResourceNotFoundException("Resource:  sprite sheet - " + spriteSheetImageName + " NOT FOUND ", e);
        }
    }

    @Override
    public SpriteSheet getSpriteSheet(String spriteSheetImageName) throws ResourceNotFoundException {
        return graphicsCache.getSpriteSheet(spriteSheetImageName); //TODO sto ako nema
    }

    @Override
    public SpriteSheet getSpriteSheet(String packedSheetName, String spriteSheetImageName) throws ResourceNotFoundException {
        return graphicsCache.getPackedSpriteSheet(packedSheetName).getSpriteSheet(spriteSheetImageName);
    }

    @Override
    public void loadImage(String imageName) throws ResourceNotFoundException {
        if (graphicsCache.doesNotComtainImage(imageName))
            try {
                graphicsCache.addImage(imageName, new Image(imageDirectory + imageName));
            } catch (SlickException e) {
                throw new ResourceNotFoundException("Resource: IMAGE - " + imageDirectory + imageName + " NOT FOUND ", e);
            }
    }

    @Override
    public Image getImage(String imageName) throws ResourceNotFoundException {
        if (graphicsCache.doesNotComtainImage(imageName))
            loadPackedSpriteSheet(imageName);
        return graphicsCache.getImage(imageName);
    }

    @Override
    public void loadAnimation(String animationName, String packedSheetName, String spriteSheet, int rows, int columns, int speed) {
        SpriteSheet sheet = getSpriteSheet(packedSheetName, spriteSheet);
        Animation animation = new Animation();
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                animation.addFrame(sheet.getSprite(x, y), speed);
            }
        }

        graphicsCache.addAnimation(animationName, animation);
    }

    @Override                          //TODO exception
    public Animation getAnimation(String animationName) {
        return graphicsCache.getAnimation(animationName);
    }
}
