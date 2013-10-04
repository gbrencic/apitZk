package zk_old.stage;

import zk_old.entity.Entity;
import zk_old.entity.EntityActionController;
import zk_old.entity.EntityType;
import pleasantnightmare.movment.Coordinates;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * User: gbrencic
 * Date: 05.04.12.
 * Time: 09:46
 */
public class Stage {
    private BaseMap map;
    private EntityActionController entityController = new EntityActionController();
    private List<Entity> entityList = new LinkedList<Entity>();
    private List<Entity> entityAfterUpdateTempList = new LinkedList<Entity>();
    private List<Entity> entityBeforeUpdateTempList = new LinkedList<Entity>();

    public Stage(BaseMap map) {
        this.map = map;
    }

    public BaseMap getMap() {
        return map;
    }

    public void endTurnUpdate() {
        entityController.doActions(this);

        //Add entities to stage
        if (entityBeforeUpdateTempList.size() >= 1) {
            addEntity(entityBeforeUpdateTempList);
            entityBeforeUpdateTempList.clear();
        }

        //Protrci po entityima
        Iterator<Entity> entityIterator = entityList.iterator();
        while (entityIterator.hasNext()) {
            Entity entity = entityIterator.next();
            if (!entity.isAlive()) {
                entityIterator.remove();
            }
        }

        //Add entities to stage
        if (entityAfterUpdateTempList.size() >= 1) {
            addEntity(entityAfterUpdateTempList);
            entityAfterUpdateTempList.clear();
        }
    }

    public List<Entity> getEntityList() {
        return entityList;
    }

    /**
     * Add entities to stage after the whole stage has finished updating
     *
     * @param entity
     */
    public void addEntityAfterUpdate(Entity entity) {
        entityAfterUpdateTempList.add(entity);
    }

    /**
     * Add entities to stage after the whole stage has finished updating
     *
     * @param entity
     */
    public void addEntityBeforeUpdate(Entity entity) {
        entityBeforeUpdateTempList.add(entity);
    }

    private void addEntity(List<Entity> entityList) {
        for (Entity entity : entityList) {
            addEntity(entity);
        }
    }

    private void addEntity(Entity entity) {
        Coordinates coordinates = entity.getCoordinates();
        if (!map.mapContainsCoordinates(coordinates))
            return;  //Rise warn


        if (entity.getEntityType().equals(EntityType.EFFECT)) {
            map.getTileAt(coordinates).setEffectEntity(entity);
        } else {
            map.getTileAt(coordinates).setMainEntity(entity);
        }
        entityList.add(entity);
    }
}
