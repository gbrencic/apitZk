package zk_old.game;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * User: gbrencic
 * Date: 22.03.12.
 * Time: 13:58
 */
public abstract class TurnCounter {
    private long turn = 0;

    public TurnCounter() {
      //  runTurnTimer();
    }

    //TODO napraviti nesto sto resetira tajmer kad se okine turn
    private void runTurnTimer() {
        //Kao da se troše action pointovi u turnu

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        TimerTask task = new TimerTask() {
            public void run() {
                endTurn();
            }
        };
        executor.scheduleWithFixedDelay(task, 1, 1, TimeUnit.SECONDS);
    }

    public abstract void endTurn();

    public long getTurn() {
        return turn;
    }

    public void nextTurn() {
        turn++;
    }
}
