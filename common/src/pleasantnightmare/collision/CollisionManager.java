package pleasantnightmare.collision;

import pleasantnightmare.Updetable;
import org.newdawn.slick.GameContainer;
import pleasantnightmare.collision.Collidable;
import pleasantnightmare.entity.BasicRoles;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.23
 * Time: 13:50:44
 * To change this template use File | Settings | File Templates.
 */
public class CollisionManager implements Updetable {
    private HashMap<BasicRoles, LinkedList<Collidable>> collisionGroups;

    public CollisionManager() {
        collisionGroups = new HashMap<BasicRoles, LinkedList<Collidable>>();
    }

    public CollisionManager(BasicRoles defaultGroupName) {
        this.collisionGroups = new HashMap<BasicRoles, LinkedList<Collidable>>();
        createGroup(defaultGroupName);
    }

    public void createGroup(BasicRoles group) {
        if (!getCollisionGroups().containsKey(group))
            getCollisionGroups().put(group, new LinkedList<Collidable>());
    }

    public void addObjectToGroup(BasicRoles name, Collidable object) {
        createGroup(name);
        getCollisionGroupByName(name).add(object);
    }

    public void addObjectToGroup(Collidable object) {
        createGroup(object.getRole());
        getCollisionGroupByName(object.getRole()).add(object);
    }

    public void removeObjectFromGroup(Collidable object) {
        if (null != getCollisionGroupByName(object.getRole()))
            getCollisionGroupByName(object.getRole()).remove(object);
        else
            removeObjectFromUnknownList(object);
    }

    private void removeObjectFromUnknownList(Collidable object) {
        for (BasicRoles s : collisionGroups.keySet()) {
            getCollisionGroupByName(s).remove(object);
        }
    }

    //Collision management
    public void detectCollision(Collidable object1, Collidable object2) {
        if (object1.getCollisionShape().intersects(object2.getCollisionShape())) {
            object1.collide(object2);
            object2.collide(object1);
        }
    }

    public void detectCollision(Collidable object1, LinkedList<Collidable> group) {
        for (Collidable object2 : group) {
            detectCollision(object1,object2);
        }
    }

    public void detectCollision(LinkedList<Collidable> group1, LinkedList<Collidable> group2) {
        for (Collidable object1 : group1) {
            for (Collidable object2 : group2) {
                detectCollision(object1,object2);
            }
        }
    }

    public void detectCollision(BasicRoles group1Name, BasicRoles group2Name) {
        LinkedList<Collidable> group1 = getCollisionGroupByName(group1Name);
        LinkedList<Collidable> group2 = getCollisionGroupByName(group2Name);
        for (Collidable object1 : group1) {
            for (Collidable object2 : group2) {
                detectCollision(object1,object2);
            }
        }
    }

    //SETTER/GETTER

    public HashMap<BasicRoles, LinkedList<Collidable>> getCollisionGroups() {
        return collisionGroups;
    }

    public LinkedList<Collidable> getCollisionGroupByName(BasicRoles name) {
        return collisionGroups.get(name);
    }


    public void update(GameContainer gc, int delta) {
         //todo Dodati provjeru za skidanje objekata koji su za maknuti ili ce se to raditi drugdje
    }
}
