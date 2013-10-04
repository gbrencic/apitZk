package zk_old.entity.actions;

import zk_old.entity.Entity;
import zk_old.stage.Stage;

/**
 * User: gbrencic
 * Date: 04.04.12.
 * Time: 11:48
 */
public interface DeathAction {
    void doAction(Entity entity, Stage stage);
}
