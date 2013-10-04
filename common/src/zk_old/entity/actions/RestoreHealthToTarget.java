package zk_old.entity.actions;

import zk_old.entity.Entity;
import zk_old.stage.Stage;

/**
 * User: gbrencic
 * Date: 04.04.12.
 * Time: 12:03
 */
public class RestoreHealthToTarget implements DeathAction {
    private Entity target;

    public void doAction(Entity entity, Stage stage) {
        target.getStatus().riseHpBy(20);
    }

    public void setTarget(Entity target) {
        this.target = target;
    }
}
