package pleasantnightmare.resources;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.14
 * Time: 13:55:45
 * To change this template use File | Settings | File Templates.
 */
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String s) {
        super(s);
    }
}
