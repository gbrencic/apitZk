package zk_old.game.engine;

/**
 * User: gbrencic
 * Date: 28.03.12.
 * Time: 09:27
 */
public interface StatusEffect {
    void doEffect(Status status);

    String getName();

    void setName(String name);

    boolean isActive();
}
