package hr.pleasantnightmare.network.simplegame;

import com.google.gson.Gson;
import hr.pleasantnightmare.network.simplegame.messages.MoveBulletMessage;
import hr.pleasantnightmare.network.simplegame.messages.MoveCharacterMessage;
import hr.pleasantnightmare.network.simplegame.messages.ShootMessage;
import hr.pleasantnightmare.network.simplegame.stage.SimpleBullet;
import hr.pleasantnightmare.network.simplegame.stage.SimpleCharacter;
import hr.pleasantnightmare.network.simplegame.stage.SimpleStage;
import org.newdawn.slick.*;
import pleasantnightmare.network.SocketClient;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * User: gbrencic
 * Date: 29.08.12.
 * Time: 13:22
 */
public class GameClient extends BasicGame {
    private GameContainer gameContainer;
    private SocketClient client;
    private Gson gson = new Gson();
    private SimpleStage stage = new SimpleStage();
    private List<String> messages = Collections.synchronizedList(new LinkedList<String>());
    private Integer playerId;

    public GameClient() {
        super("SimpleGameClinet v0.1");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.gameContainer = gameContainer;

        client = new SocketClient("localhost", 9999) {
            @Override
            public void serverMessageRecieved(String message) {
                //TODO nakrcati ih u neku listu... pa ih se odradi...
                messages.add(message);
            }
        };
    }

    private void parseServerMessage(String message) {
        System.out.println("MSG-> " + message);
        SimpleGameEnums tip = SimpleGameEnums.valueOf(message.substring(0, 6));    //Nekako bolje ovo ? kompleksni objekt s tipom unutra je bolje od parsiranja...
        message = message.substring(6);

        if (tip.equals(SimpleGameEnums.MV_BLT)) {
            final MoveBulletMessage sb = gson.fromJson(message, MoveBulletMessage.class);
            stage.moveBullet(sb);
        } else if (tip.equals(SimpleGameEnums.BULLET)) {
            final SimpleBullet sb = gson.fromJson(message, SimpleBullet.class);
            stage.addBullet(sb);
        } else if (tip.equals(SimpleGameEnums.CHARAC)) {
            final SimpleCharacter player = gson.fromJson(message, SimpleCharacter.class);
            stage.addCharacter(player);
        } else if (tip.equals(SimpleGameEnums.MVMENT)) {
            final MoveCharacterMessage mvmnt = gson.fromJson(message, MoveCharacterMessage.class);
            stage.moveCharacter(mvmnt);
        } else if (tip.equals(SimpleGameEnums.IDPLAY)) {
            playerId = gson.fromJson(message, Integer.class);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        final LinkedList<String> msgs = new LinkedList<String>(messages);
        messages.clear();
        for (String message : msgs) {
            parseServerMessage(message);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawString(String.valueOf(stage.getBullets().size()), 100, 20);

        for (SimpleCharacter player : stage.getCharacters().values()) {
            graphics.draw(player.getShape());
        }

        for (SimpleBullet bullet : stage.getBullets()) {
            if (!stage.positionIsOffStage(bullet.getPosX() + 20, bullet.getPosY() - 20)) {
                graphics.draw(bullet.getShape());
            } else {
                stage.removeBullet(bullet.getId());
            }
        }
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new GameClient());
            container.setDisplayMode(500, 500, false);
//            container.setMouseGrabbed(true);
            container.setMouseGrabbed(false);
            container.setAlwaysRender(true); //TESTA RADI
            container.setUpdateOnlyWhenVisible(false);
            container.setTargetFrameRate(30);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void keyPressed(int key, char c) {

        if (key == Input.KEY_ESCAPE) {
            gameContainer.exit();
        }

        if (key == Input.KEY_ENTER) {
            SimpleCharacter character = stage.getCharacterById(playerId);

            ShootMessage shootMessage = new ShootMessage(character.getPosX(), character.getPosY(), character.getDirection());
            for (int i = 0; i < 100; i++) {
                client.sendMessageToServer(SimpleGameEnums.SHOOT_ + gson.toJson(shootMessage));
            }
        }

        if (key == Input.KEY_RIGHT) {
            SimpleCharacter character = stage.getCharacterById(playerId);
            float toX = character.getPosX() + 5f;
            character.setDirection(4);
            MoveCharacterMessage moveMessage = new MoveCharacterMessage(playerId, toX, character.getPosY());
            client.sendMessageToServer(SimpleGameEnums.MVMENT + gson.toJson(moveMessage));
        }
        if (key == Input.KEY_LEFT) {
            SimpleCharacter character = stage.getCharacterById(playerId);
            float toX = character.getPosX() - 5f;
            character.setDirection(3);
            MoveCharacterMessage moveMessage = new MoveCharacterMessage(playerId, toX, character.getPosY());
            client.sendMessageToServer(SimpleGameEnums.MVMENT + gson.toJson(moveMessage));
        }
        if (key == Input.KEY_UP) {
            SimpleCharacter character = stage.getCharacterById(playerId);
            float toY = character.getPosY() - 5f;
            character.setDirection(1);
            MoveCharacterMessage moveMessage = new MoveCharacterMessage(playerId, character.getPosX(), toY);
            client.sendMessageToServer(SimpleGameEnums.MVMENT + gson.toJson(moveMessage));
        }
        if (key == Input.KEY_DOWN) {
            SimpleCharacter character = stage.getCharacterById(playerId);
            float toY = character.getPosY() + 5f;
            character.setDirection(2);
            MoveCharacterMessage moveMessage = new MoveCharacterMessage(playerId, character.getPosX(), toY);
            client.sendMessageToServer(SimpleGameEnums.MVMENT + gson.toJson(moveMessage));
        }
    }
}

