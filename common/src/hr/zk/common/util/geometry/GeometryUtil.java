package hr.zk.common.util.geometry;

import org.newdawn.slick.geom.Vector2f;

//import org.newdawn.slick.geom.Vector2f;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.15
 * Time: 13:02:37
 * To change this template use File | Settings | File Templates.
 */
public class GeometryUtil {
    /**
     * The angle should be in radians.
     */
    public static Vector2f calculateVector(float magnitude, float angle) {
        Vector2f v = new Vector2f();
        v.x = (float) Math.sin(angle);
        v.x *= magnitude;
        v.y = (float) -Math.cos(angle);
        v.y *= magnitude;
        return v;
    }

    /**
     * From x,y -> x1,y1
     *
     * @return The value is in radians.
     */
    public static float calculateAngle(float x, float y, float x1, float y1) {
        double angle = Math.atan2(y - y1, x - x1);
        return (float) angle + 1.5f;
    }

    /**
     * Return the distance squared between two points.
     */
    public static float distance2(float x, float y, float x1, float y1) {
        x = (float) Math.pow(x - x1, 2);
        y = (float) Math.pow(y - y1, 2);
        return (x + y);
    }

    public static float distance2(float[] p1, float x, float y) {
        return distance2(p1[0], p1[1], x, y);
    }
}
