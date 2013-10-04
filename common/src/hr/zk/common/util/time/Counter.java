package hr.zk.common.util.time;

/**
 * User: gbrencic
 * Date: 01.10.13.
 * Time: 15:55
 *
 * Counter based on delta time
 */
public abstract class Counter {
//TODO srediti
    private int delay;
    private int counter;

    public Counter(int delay) {
        this.delay = delay;
    }

    public void update(int delta) {
        counter = counter + delta;

        if (counter >= delay) {
            performAction();
            reset();
        }
    }

    public void reset() {
        counter = 0;
    }

    public int getCount() {
        return counter;
    }

    public abstract void performAction();
}
