package zk_old.game.engine;

import zk_old.model.InfoMessageBuffer;

/**
 * User: gbrencic
 * Date: 28.03.12.
 * Time: 09:27
 */
public class PoisonEffect implements StatusEffect {
    private String name = "Poison";
    private int duration = 3;
    private boolean active = true;

    public void doEffect(Status status) {
        InfoMessageBuffer.addInfoMessage("The poison reacts! (3)");
        status.lowerHpBy(3);
        duration--;

        if (duration == 0)
            setActive(false);
    }

    public boolean isActive() {
        return active;
    }

    private void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
