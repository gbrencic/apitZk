package zk_old.stage;

import zk_old.entity.Entity;
import zk_old.entity.EntityType;
import pleasantnightmare.movment.Coordinates;

import java.util.LinkedList;
import java.util.List;

/**
 * User: gbrencic
 * Date: 22.03.12.
 * Time: 11:12
 */
public class MapTile {
    private Coordinates coordinates;
    private final boolean blockable;
    private String graphic;
    private Entity mainEntity; //Creature or object only one //Tile Block like a wall etc  should be a mainEntity?
    private Entity effectEntity; //Effect on the tile, fire smoke etc
    private List<Entity> secondaryEntityList;

    public MapTile(String graphic, boolean blockable, Coordinates coordinates) {
        this.graphic = graphic;
        this.blockable = blockable;
        this.coordinates = coordinates;
        secondaryEntityList = new LinkedList<Entity>();
    }

    public static MapTile getNullTile() {
        return new MapTile(null, false, null);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public boolean isBlockMovement() {
        if (containsMainEntity() && getMainEntity().isBlockMovement())
            return true;
        return blockable;
    }

    public boolean isWalkOver() {
        if (containsMainEntity() && mainEntity.getEntityType().equals(EntityType.WALKABLE_TILE))
            return true;
        return false;
    }

    public boolean isEntityReciever() {
        if (isBlockMovement())
            return false;

        if (null != mainEntity)
            return false;

        return true;
    }

    public String getGraphic() {
        if (containsEffectEntity())
            return effectEntity.getGraphics();
        if (containsMainEntity())
            return mainEntity.getGraphics();
        return graphic;
    }

    public void transferMainEntityToTile(MapTile endMapTile) {
        endMapTile.setMainEntity(getMainEntity());
        removeMainEntitiy();
    }

    private void removeMainEntitiy() {
        mainEntity = null;
    }

    public Entity getMainEntity() {
        if (null != mainEntity && !mainEntity.isAlive())
            mainEntity = null;
        return mainEntity;
    }

    public void setEffectEntity(Entity effectEntity) {
        this.effectEntity = effectEntity;
    }

    public Entity getEffectEntity() {
        if (null != effectEntity && !effectEntity.isAlive())
            effectEntity = null;
        return effectEntity;
    }

    public List<Entity> getSecondaryEntityList() {
        return secondaryEntityList;
    }

    public void addSecondaryEntity(Entity entity) {
        this.secondaryEntityList.add(entity);
    }

    public void setMainEntity(Entity mainEntity) {
        this.mainEntity = mainEntity;
    }


    public boolean containsMainEntity() {
        return null != getMainEntity();
    }

    public boolean containsEffectEntity() {
        return null != getEffectEntity();
    }
}
