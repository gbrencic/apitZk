package hr.pleasantnightmare.pathfinding.kevin;

import org.newdawn.slick.util.pathfinding.Mover;

/**
 * User: gbrencic
 * Date: 31.08.12.
 * Time: 11:09
 */
public class UnitMover implements Mover {
    /**
     * The unit ID moving
     */
    private int type;

    /**
     * Create a new mover to be used while path finder
     *
     * @param type The ID of the unit moving
     */
    public UnitMover(int type) {
        this.type = type;
    }

    /**
     * Get the ID of the unit moving
     *
     * @return The ID of the unit moving
     */
    public int getType() {
        return type;
    }
}