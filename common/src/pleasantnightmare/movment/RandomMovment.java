package pleasantnightmare.movment;

import java.util.Random;

/**
 * User: gbrencic
 * Date: 04.04.12.
 * Time: 14:30
 */
public class RandomMovment extends Movement {
    public RandomMovment(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void doMove() {
        int move = new Random().nextInt(5);

        if (move == 1)
            moveRight();
        if (move == 2)
            moveLeft();
        if (move == 3)
            moveUp();
        if (move == 4)
            moveDown();
    }
}
