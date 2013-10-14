package hr.zk.common.entity;

/**
 * User: gbrencic
 * Date: 02.10.13.
 * Time: 11:27
 */
public interface Entity {

    Long getId();

    String getName();

    float getPosX();

    float getPosY();

    public Role getRole();

    void setPosX(float posX);

    void setPosY(float posY);
}
