package hr.pleasantnightmare.network.simplegame.stage;

import hr.pleasantnightmare.network.simplegame.messages.MoveBulletMessage;
import hr.pleasantnightmare.network.simplegame.messages.MoveCharacterMessage;

import java.util.*;

/**
 * User: gbrencic
 * Date: 29.08.12.
 * Time: 13:25
 */
public class SimpleStage { //POstoje 2 stagea player i server
    private transient Map<Integer, SimpleCharacter> characters = Collections.synchronizedMap(new HashMap<Integer, SimpleCharacter>());
    private transient List<SimpleBullet> bullets = Collections.synchronizedList(new LinkedList<SimpleBullet>());
    private int sizeX = 500;
    private int sizeY = 500;


    public void addCharacter(SimpleCharacter character) {
        synchronized (characters) {
            characters.put(character.getId(), character);
        }
    }

    public Map<Integer, SimpleCharacter> getCharacters() {
        return characters;
    }

    public SimpleCharacter getCharacterById(int id) {
        return characters.get(id);
    }

    public void moveCharacter(MoveCharacterMessage mvmnt) {
        final SimpleCharacter character = characters.get(mvmnt.getId());
        character.setPosX(mvmnt.getToX());
        character.setPosY(mvmnt.getToY());
    }

    public void addBullet(SimpleBullet bullet) {
        synchronized (bullets) {
            bullets.add(bullet);
        }
    }

    public synchronized List<SimpleBullet> getBullets() {
        return bullets;
    }

    public SimpleBullet getBulletById(Integer id) {
        //Sporo no privremeno zbog concurency pogledati
        for (SimpleBullet bullet : bullets) {
            if (bullet.getId().equals(id))
                return bullet;
        }
        System.out.println("no sutch entity!");
        return null;
    }

    public void moveBullets() {   //TODO samo server mice metke... javlja se lokalnom playeru...
        Iterator<SimpleBullet> it = bullets.iterator();
        while (it.hasNext()) {
            SimpleBullet bullet = it.next();

            if (!positionIsOffStage(bullet.getPosX(), bullet.getPosY())) {
                if (bullet.getDirection() == 1)    //up
                    bullet.setPosY(bullet.getPosY() - 2);
                if (bullet.getDirection() == 2)   //dwn
                    bullet.setPosY(bullet.getPosY() + 2);
                if (bullet.getDirection() == 3)     //lft
                    bullet.setPosX(bullet.getPosX() - 2);
                if (bullet.getDirection() == 4)       //rt
                    bullet.setPosX(bullet.getPosX() + 2);
            }

            if (positionIsOffStage(bullet.getPosX(), bullet.getPosY())) {
                it.remove();
            }
        }
    }

    public void removeBullet(Integer id) {
        synchronized (bullets) {
            bullets.remove(id);
        }
    }

    public void moveBullet(MoveBulletMessage move) {
        SimpleBullet bullet = getBulletById(move.getId());
        if (null != bullet) {            //Ovo bi trebalo pucati jer ne postoji bullet... ili traziti od servera entitet sa tim idem
            bullet.setPosX(move.getToX());
            bullet.setPosY(move.getToY());
        }
    }

    public boolean positionIsOffStage(float posX, float posY) {
        if (posX <= 0 || posX >= sizeX) return true;
        if (posY <= 0 || posY >= sizeX) return true;
        return false;
    }
}
