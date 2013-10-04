package hr.zk.junkyard.shaders;

/**
 * User: gbrencic
 * Date: 02.10.13.
 * Time: 15:54
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * An image loaded from a file and renderable to the canvas
 *
 * @author kevin
 */
public class SlickImage extends Image {


    /**
     * Creates an image intended for use with offscreen rendering. Only one
     * texture is created (the FBO/PBuffer-bound texture which will be used
     * internally). This replaces the old way of offscreen rendering, using
     * <tt>new Image(width, height)</tt>.
     *
     * @param width  the width of the offscreen image
     * @param height the height of the offscreen image
     * @param filter the desired filtering (FILTER_NEAREST or FILTER_LINEAR)
     * @return a new Image prepared for use with getGraphics()
     * @throws SlickException if there was a problem constructing the offscreen image
     */
    public static Image createOffscreenImage(int width, int height, int filter) throws SlickException {
       /* // this is a bit hackish; ideally FBO/Image should be restructured into
        // a more OpenGL-like design...
        // but that would introduce a major overhaul of the library
        Image i = new Image();
        i.width = width;
        i.height = height;
        i.filter = filter;
        i.inited = true; // so that initImpl() only gets called once
        i.getGraphics(); // will call Image.setTexture, which calls reinit
        return i;*/
        return null;
    }

}