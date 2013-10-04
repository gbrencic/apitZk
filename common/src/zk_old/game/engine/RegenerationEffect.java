package zk_old.game.engine;

/**
 * User: gbrencic
 * Date: 28.03.12.
 * Time: 09:27
 */
public class RegenerationEffect implements StatusEffect {
    private String name = "Regeneration";
    private int duration = -1;
    private boolean active = true;

    private int counter = 5;
    private int regenerationRate = 5;
    private int regenerationHp = 1;

    public void doEffect(Status status) {
        counter--;

        if (counter == 0) {
            counter = regenerationRate;
            status.riseHpBy(regenerationHp);
        }
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
}
