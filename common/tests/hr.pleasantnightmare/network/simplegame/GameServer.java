package hr.pleasantnightmare.network.simplegame;

import com.google.gson.Gson;
import hr.pleasantnightmare.network.simplegame.messages.MoveBulletMessage;
import hr.pleasantnightmare.network.simplegame.messages.MoveCharacterMessage;
import hr.pleasantnightmare.network.simplegame.messages.ShootMessage;
import hr.pleasantnightmare.network.simplegame.stage.SimpleBullet;
import hr.pleasantnightmare.network.simplegame.stage.SimpleCharacter;
import hr.pleasantnightmare.network.simplegame.stage.SimpleStage;
import hr.pleasantnightmare.network.simplegame.util.IdProvider;
import pleasantnightmare.network.Client;
import pleasantnightmare.network.SocketMultiClientServer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * User: gbrencic
 * Date: 29.08.12.
 * Time: 13:21
 */
public class GameServer {
    private SimpleStage stage;
    private Gson gson = new Gson();
    private SocketMultiClientServer server;

    public GameServer() {
        stage = new SimpleStage();
        server = createServer();
    }
    //Fali neki update loop

    private SocketMultiClientServer createServer() {
        return new SocketMultiClientServer(9999) {
            @Override
            public void update(List<Client> clients, ConcurrentLinkedQueue<String> messages) {
                while (!messages.isEmpty()) {
                    resolveMessage(messages.poll());
                }
                //Move bullets
                stage.moveBullets();
                System.out.println(stage.getBullets().size());

                final MoveBulletMessage mv = new MoveBulletMessage();
                for (Client client : clients) {
                    for (SimpleBullet bulet : stage.getBullets()) {           //Concurrent modification eception...!!!
                        if (!stage.positionIsOffStage(bulet.getPosX(), bulet.getPosX())) {
                            mv.setId(bulet.getId());
                            mv.setToX(bulet.getPosX());
                            mv.setToY(bulet.getPosY());
                            client.sendMessage(SimpleGameEnums.MV_BLT + gson.toJson(mv));
                        }
                    }
                }
            }

            @Override
            public void clientConnected(Client client) {            //TODO ID IDE IZ UNIQUA
                final SimpleCharacter newCharacter = new SimpleCharacter(IdProvider.getNextId(), new Random().nextInt(200) + 50, new Random().nextInt(200) + 50);
                stage.addCharacter(newCharacter);

                //Init klijenta koji se spojio
                client.sendMessage(SimpleGameEnums.IDPLAY + "" + newCharacter.getId());

                //Update ostalih klijenta koji su u blizini ... ne sve ... ovo ce vjerojatno ici na tile base i id update...  samo ga vide oni koji su u djiru
                for (Client clienti : getClients()) {
                    for (SimpleCharacter character : stage.getCharacters().values()) { //Preomenovati player u character
                        clienti.sendMessage(SimpleGameEnums.CHARAC + gson.toJson(character));     //Todo Parser
                    }
                }
            }
        };
    }

    //TODO izvuci vani
    private void resolveMessage(String message) {
        SimpleGameEnums tip = SimpleGameEnums.valueOf(message.substring(0, 6));    //Nekako bolje ovo ? kompleksni objekt s tipom unutra je bolje od parsiranja...
        String shortMessage = message.substring(6);

        if (tip.equals(SimpleGameEnums.MVMENT)) {
            final MoveCharacterMessage mvmnt = gson.fromJson(shortMessage, MoveCharacterMessage.class);
            stage.moveCharacter(mvmnt);
        }

        if (tip.equals(SimpleGameEnums.SHOOT_)) {
            final ShootMessage msg = gson.fromJson(shortMessage, ShootMessage.class);
            SimpleBullet bullet = new SimpleBullet(IdProvider.getNextId(), msg.getPosX(), msg.getPosY(), msg.getDirection());

            stage.addBullet(bullet);
            message = SimpleGameEnums.BULLET + "" + gson.toJson(bullet);
        }

        for (Client client : server.getClients()) {       //Pošalji svima sto je netko napisao
            client.sendMessage(message);
        }
    }

    public static void main(String[] args) {
        new GameServer();
    }
}
