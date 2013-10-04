package hr.zk.common.resources;

/**
 * User: gbrencic
 * Date: 02.10.13.
 * Time: 12:27
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message,Exception e) {
        super(message,e);
    }
}
