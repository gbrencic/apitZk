package pleasantnightmare.geometry;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.15
 * Time: 14:00:51
 * To change this template use File | Settings | File Templates.
 */

import pleasantnightmare.entity.Body;
import pleasantnightmare.geometry.GeometryUtil;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.15
 * Time: 12:50:26
 * To change this template use File | Settings | File Templates.
 */


public class Geometry {

    /**
     * Returns the distance squared between the two body's centers.
     */
    public static float distance2(Body one, Body two) {
        float x = one.getPosX() - two.getPosX();
        x = x * x;
        float y = one.getPosY() - two.getPosY();
        y = y * y;
        return (x + y);
    }

    public static float distance2(Body one, float x2, float y2) {
        float x = one.getPosX() - x2;
        x = x * x;
        float y = one.getPosY() - y2;
        y = y * y;
        return (x + y);
    }

    public static float distance(Body one, Body two) {
        return (float) Math.sqrt(distance2(one, two));
    }

    public static float distance(Body one, float x2, float y2) {
        return (float) Math.sqrt(distance2(one, x2, y2));
    }

    public static float calculateAngle(Body one, Body two) {
        float x1 = one.getPosX();
        float y1 = one.getPosY();
        float x2 = two.getPosX();
        float y2 = two.getPosY();
        return GeometryUtil.calculateAngle(x1, y1, x2, y2);
    }

    public static float calculateAngle(Body one, float x2, float y2) {
        float x1 = one.getPosX();
        float y1 = one.getPosY();
        return GeometryUtil.calculateAngle(x1, y1, x2, y2);
    }

}