package hr.zk.common.entity;

/**
 * User: gbrencic
 * Date: 11.10.13.
 * Time: 12:05
 */
public class DefaultEntityLocationUtil {
    /**
     * Returns the distance squared between the two Entity's centers.
     */
    public static float distance2(Entity one, Entity two) {
        float x = one.getPosX() - two.getPosX();
        x = x * x;
        float y = one.getPosY() - two.getPosY();
        y = y * y;
        return (x + y);
    }

    public static float distance2(Entity one, float x2, float y2) {
        float x = one.getPosX() - x2;
        x = x * x;
        float y = one.getPosY() - y2;
        y = y * y;
        return (x + y);
    }

    public static float distance(Entity one, Entity two) {
        return (float) Math.sqrt(distance2(one, two));
    }

    public static float distance(Entity one, float x2, float y2) {
        return (float) Math.sqrt(distance2(one, x2, y2));
    }

    public static float calculateAngle(Entity one, Entity two) {
        float x1 = one.getPosX();
        float y1 = one.getPosY();
        float x2 = two.getPosX();
        float y2 = two.getPosY();

        return calculateAngle(x1, y1, x2, y2);
    }

    public static float calculateAngle(Entity one, float x2, float y2) {
        float x1 = one.getPosX();
        float y1 = one.getPosY();
        return calculateAngle(x1, y1, x2, y2);
    }

    private static float calculateAngle(float x, float y, float x1, float y1) {
        double angle = Math.atan2(y - y1, x - x1);
        return (float) angle + 1.5f;
    }

}
