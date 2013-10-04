package pleasantnightmare.graphics;

/**
 * User: Shivesh
 * Date: 2007.11.10
 * Time: 22:50:40
 */
public class SpriteFactory {
  /*  public String imageDirectory;
    GraphicsLoader spriteSheetDataSource;

    public GraphicsFactory(String imageDirectory) {
        this.imageDirectory = imageDirectory;
        spriteSheetDataSource = new GraphicsLoader(imageDirectory);
    }

    public void loadPackedSpriteSheet(String spriteSheetName) throws SlickException {
        spriteSheetDataSource.loadPackedSpriteSheet(spriteSheetName);
    }

    public void registerImage(String imageName) throws SlickException {
        spriteSheetDataSource.registerImage(imageName);
    }

    public Animation getAnimation(String packedSheetName, String spriteSheet, int rows, int columns, int speed) throws SlickException {
        SpriteSheet sheet = spriteSheetDataSource.getSpriteSheet(packedSheetName, spriteSheet);
        Animation animation = new Animation();
        for (int y = 0; y < columns; y++) {
            for (int x = 0; x < rows; x++) {
                animation.addFrame(sheet.getSprite(x,y), speed);
            }
        }
       return animation;
    }

    public Animation getAnimation(String packedSheetName, String spriteSheet) throws SlickException {
        SpriteSheet sheet = spriteSheetDataSource.getSpriteSheet(packedSheetName, spriteSheet);
        Animation animation = new Animation();
       animation.addFrame(sheet.getSprite(1,1),80);
       return animation;
    }

    public Image getImageFromSpritesheet(String spriteSheetName, String spriteName) throws SlickException {
        return spriteSheetDataSource.getSpriteSheet(spriteSheetName,spriteName);
    }

    public Image get(String imageName) throws SlickException {
        return spriteSheetDataSource.get(imageName);
    }*/
}
