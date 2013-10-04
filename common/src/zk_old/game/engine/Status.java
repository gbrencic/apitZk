package zk_old.game.engine;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * User: gbrencic
 * Date: 22.03.12.
 * Time: 15:15
 */
public class Status {
    private int hp = 10;
    private final List<StatusEffect> statusEffects = new LinkedList<StatusEffect>();

    public int getHp() {
        return hp;
    }

    public void lowerHpBy(int hp) {
        this.hp = this.hp - hp;
    }

    public void riseHpBy(int hp) {
        this.hp = this.hp + hp;
    }

    public void addStatusEffect(StatusEffect statusEffect) {
        statusEffects.add(statusEffect);
    }

    public void update() {
        Iterator<StatusEffect> i = statusEffects.iterator();
        while (i.hasNext()) {
            StatusEffect statusEffect = i.next();
            triggerStatusEvent(i, statusEffect);
        }
    }

    private void triggerStatusEvent(Iterator<StatusEffect> i, StatusEffect statusEffect) {
        if (!statusEffect.isActive()) {
            i.remove();
        } else {
            statusEffect.doEffect(this);
        }
    }
}
