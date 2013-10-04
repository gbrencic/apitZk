package pleasantnightmare.application;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.14
 * Time: 13:45:13
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationContext {
    private String imageDirectory = "";

    public ApplicationContext() {

    }

    public String getImageDirectory() {
        return imageDirectory;
    }

    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }
}
