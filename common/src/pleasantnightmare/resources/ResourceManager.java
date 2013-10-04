package pleasantnightmare.resources;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.15
 * Time: 15:20:08
 * To change this template use File | Settings | File Templates.
 */
public class ResourceManager {
    public ImageDataSourceImpl imageDataSource;

    public ResourceManager() {
        imageDataSource = new ImageDataSourceImpl();
    }
}
