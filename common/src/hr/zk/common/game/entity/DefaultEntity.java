package hr.zk.common.game.entity;

/**
 * User: gbrencic
 * Date: 02.10.13.
 * Time: 11:27
 */
public class DefaultEntity implements Entity {
    protected final Long id;
    protected String name;
    protected double positionX;
    protected double positionY;

    public DefaultEntity(Long id, String name, double positionX, double positionY) {
        this.id = id;
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }
}
