package hr.zk.common.entity;

/**
 * User: gbrencic
 * Date: 02.10.13.
 * Time: 11:27
 */
public class DefaultEntity implements Entity {
    protected final Long id;
    protected String name;
    protected float posX;
    protected float posY;
    private Role role = DefaultRoles.UNASSIGNED;

    public DefaultEntity(Long id, String name, float posX, float posY) {
        this.id = id;
        this.name = name;
        this.posX = posX;
        this.posY = posY;
    }

    public DefaultEntity(Long id, String name, float posX, float posY, Role role) {
        this.id = id;
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.role = role;
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

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    @Override
    public Role getRole() {
        return role;
    }
}
