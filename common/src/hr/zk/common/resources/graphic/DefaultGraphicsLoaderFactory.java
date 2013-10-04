package hr.zk.common.resources.graphic;

/**
 * User: gbrencic
 * Date: 04.10.13.
 * Time: 13:55
 */
public class DefaultGraphicsLoaderFactory implements GraphicsLoaderFactory {
    @Override
    public GraphicsLoader create(String graphicsDirectory) {
        final GraphicsCache graphicsCache = new DefaultGraphicsCache();
        return new DefaultGraphicsLoader(graphicsDirectory, graphicsCache);
    }
}
