package hr.zk.common.game.engine.dice;

/**
 * User: gbrencic
 * Date: 01.10.13.
 * Time: 15:44
 */
public class DefaultDice implements Dice {
    private final int sides;

    public DefaultDice(int sides) {
        this.sides = sides;
    }

    @Override
    public int roll() {
        return (int)(Math.random() * sides + 1);
    }

    @Override
    public int getNumberOfSides() {
        return sides;
    }
}
