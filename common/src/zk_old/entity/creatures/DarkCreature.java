package zk_old.entity.creatures;

import zk_old.entity.Entity;
import zk_old.entity.EntityImpl;
import zk_old.entity.EntityType;
import zk_old.entity.actions.Explosion;
import zk_old.stage.TextGraphics;
import zk_old.model.InfoMessageBuffer;
import pleasantnightmare.movment.Coordinates;
import pleasantnightmare.movment.RandomMovment;

/**
 * User: gbrencic
 * Date: 22.03.12.
 * Time: 15:24
 */
public class DarkCreature extends EntityImpl {

    public DarkCreature(Coordinates coordinates) {
        super(EntityType.CREATURE,TextGraphics.ENEMY, coordinates);
        addDeathAction(new Explosion());
        setMovement(new RandomMovment(coordinates));
    }

    @Override
    public void interact(Entity entity) {

    }

    @Override
    public void endTurnUpdate() {
        super.endTurnUpdate();
        getMovement().doMove();
    }

    @Override
    public void die() {
        super.die();
        InfoMessageBuffer.addInfoMessage("DarkCreature dies!");
    }
}
