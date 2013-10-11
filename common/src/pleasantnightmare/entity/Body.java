package pleasantnightmare.entity;

import hr.zk.common.entity.DefaultRoles;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.14
 * Time: 14:58:01
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public abstract class Body {
    protected float posX;
    protected float posY;

    private DefaultRoles role;
    private String id;

    public Body(String id, float posX, float posY, DefaultRoles role) {
        this.posX = posX;
        this.posY = posY;
        this.role = role;
        this.id = id;
    }

      public Body(String id, DefaultRoles role) {
        this.posX = 0;
        this.posY = 0;
        this.role = role;
        this.id = id;
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

    public DefaultRoles getRole() {
        return role;
    }

    public void setRole(DefaultRoles role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
