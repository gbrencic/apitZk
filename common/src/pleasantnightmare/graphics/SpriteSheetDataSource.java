package pleasantnightmare.graphics;

import org.newdawn.slick.SlickException;

/**
 * User: Shivesh
 * Date: 2007.11.10
 * Time: 23:13:45
 */
@Deprecated
public class SpriteSheetDataSource {
    //todo prebaciti u resources
   /* private String imageDirectory;
    private HashMap<String, PackedSpriteSheet> sheets;
    private HashMap<String, Image> images;
    private HashMap<String, Animation> animations;

    public GraphicsLoader(String imageDirectory) {
        this.imageDirectory = imageDirectory;
        sheets = new HashMap<String, PackedSpriteSheet>();
        images = new HashMap<String, Image>();
    }

    *//**
     * Load Sprite Sheet into memory
     *
     * @param packedSheetName
     * @throws SlickException
     *//*
    public void loadPackedSpriteSheet(String packedSheetName) throws SlickException {
        if (!sheets.containsKey(packedSheetName))
            sheets.put(packedSheetName, new PackedSpriteSheet(imageDirectory + packedSheetName + ".def", Image.FILTER_NEAREST));
    }

    public PackedSpriteSheet getPackedSpriteSheet(String packedSheetName) throws SlickException {
        if (!sheets.containsKey(packedSheetName))
            loadPackedSpriteSheet(packedSheetName);

        return sheets.get(packedSheetName);
    }

    public SpriteSheet getSpriteSheet(String packedSheetName, String sheetName) throws SlickException {
        return getPackedSpriteSheet(packedSheetName).getSpriteSheet(sheetName);
    }

    *//**
     * Load Image Into Memory
     *
     * @param imageName
     * @throws SlickException
     *//*
    public void registerImage(String imageName) throws SlickException {
        if (!images.containsKey(imageName))
            images.put(imageName, new Image(imageDirectory + imageName));
    }

    public Image get(String imageName) throws SlickException {
        if (!images.containsKey(imageName))
            loadPackedSpriteSheet(imageName);
        return images.get(imageName);
    }

    public void clearAll() {
        clearSheets();
        clearImages();
    }

    public void clearSheets() {
        sheets.clear();
    }

    public void clearImages() {
        images.clear();
    }*/
}
