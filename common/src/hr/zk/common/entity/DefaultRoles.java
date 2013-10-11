package hr.zk.common.entity;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.15
 * Time: 12:58:27
 */
public enum DefaultRoles implements Role {
    UNASSIGNED,
    PLAYER, MOCK_PLAYER,
    NPC,
    MONSTER,
    ENEMY,

    OBSTACLE, IMPASSABLE_OBSTACLE,

    WATER,
    DUMMY,
    TREASURE,
    GUICOMPONENT,
    STATIC_OBJECT,
    WEAPON
}
