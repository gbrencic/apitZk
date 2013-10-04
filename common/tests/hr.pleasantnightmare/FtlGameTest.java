/*
package pleasantnightmare;

import hr.zk.entity.Entity;
import hr.zk.entity.creatures.BasicPlayer;
import hr.zk.entity.creatures.LightCreature;
import hr.zk.entity.inanimate.Tree;
import hr.zk.entity.weapons.Bomb;
import hr.zk.entity.weapons.Bullet;
import hr.zk.entity.weapons.Granade;
import hr.zk.game.TurnCounter;
import hr.zk.game.engine.RegenerationEffect;
import hr.zk.graphic.TextRenderer;
import hr.zk.gui.GameScreen;
import hr.zk.model.InfoMessageBuffer;
import hr.zk.movment.Coordinates;
import hr.zk.movment.Movement;
import org.newdawn.slick.ImageBuffer;
import hr.zk.stage.BaseMap;
import hr.zk.stage.BaseMapFactory;
import hr.zk.stage.MapDimensions;
import hr.zk.stage.Stage;

import java.awt.*;
import java.awt.event.KeyEvent;

*/
/**
 * User: gbrencic
 * Date: 02.03.12.
 * Time: 14:12
 *//*

public class FtlGameTest {
    private GameScreen gameScreen = new GameScreen();
    private TextRenderer renderer;
    private Stage stage;
    private Entity player;
    private TurnCounter turnCounter;

    public FtlGameTest() {
        renderer = new TextRenderer(gameScreen.getMapLabel());//new ImageRenderer(gameScreen.getMapLabel());

        BaseMap map = BaseMapFactory.getSquareMap(new MapDimensions(20, 20, 3));
        stage = new Stage(map);
        map = BaseMapFactory.addHill(stage.getMap(), stage);
        map = BaseMapFactory.addTrees(stage.getMap(), stage);

        //CreatePlayer
        player = new BasicPlayer(new Coordinates(5, 5));
        player.getStatus().addStatusEffect(new RegenerationEffect());
        stage.addEntityBeforeUpdate(player);

        stage.addEntityBeforeUpdate(new Tree(new Coordinates(3, 3)));

        //CreateBeasts
        final LightCreature lightCreature = new LightCreature(new Coordinates(3, 3));
        lightCreature.setTargetToFollow(player);
        //     stage.addEntityBeforeUpdate(lightCreature);

        //   stage.addEntityBeforeUpdate(new DarkCreature(new Coordinates(2, 2)));
        //  stage.addEntityBeforeUpdate(new DarkCreatureSpawnPoint(new Coordinates(7, 7), stage));


        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new KeyboardInputDispatcher());
        turnCounter = new TurnCounter() {
            @Override
            public void endTurn() {
                endTurnAction();
            }
        };

        //for (int i = 0; i < 10000; i++) {
        endTurnAction();
        //}
    }

    public void endTurnAction() {
        turnCounter.nextTurn();
        stage.endTurnUpdate();
        renderer.drawMap(stage.getMap(), player.getCoordinates());

        //Build info screen
        String info = String.valueOf("Turn:" + turnCounter.getTurn());
        InfoMessageBuffer.addInfoMessage(info);
        InfoMessageBuffer.addInfoMessage("Entites: " + stage.getEntityList().size());
        gameScreen.getInfoLabel().setText(InfoMessageBuffer.getInfoMessages());
        gameScreen.getStatusLabel().setText(" HP: " + player.getStatus().getHp());

        InfoMessageBuffer.clearInfoMessages();
    }

    private class KeyboardInputDispatcher implements KeyEventDispatcher {
        public boolean dispatchKeyEvent(KeyEvent e) {
            Movement movement = player.getMovement();

            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (e.getKeyCode() == 38) //Up
                    movement.moveUp();

                if (e.getKeyCode() == 40) //Down
                    movement.moveDown();

                if (e.getKeyCode() == 37) //Left
                    movement.moveLeft();

                if (e.getKeyCode() == 39) //Right
                    movement.moveRight();

                if (e.getKeyCode() == 36) //Home
                    movement.riseLevel();

                if (e.getKeyCode() == 35) //End
                    movement.loverLevel();

                if (e.getKeyCode() == 32) {//Space
                    Coordinates coordinates = new Coordinates(movement.getEndPosition());
                    coordinates.setX(coordinates.getX() + 1);
                    stage.addEntityBeforeUpdate(new Bomb(coordinates));
                }

                if (e.getKeyCode() == 17) {//LCtrl
                    Coordinates coordinates = new Coordinates(movement.getEndPosition());
                    coordinates.setX(coordinates.getX() + 1);
                    stage.addEntityBeforeUpdate(new Bullet(coordinates));
                }

                if (e.getKeyCode() == 18) {//LAlt
                    Coordinates coordinates = new Coordinates(movement.getEndPosition());
                    coordinates.setX(coordinates.getX() + 1);
                    stage.addEntityBeforeUpdate(new Granade(coordinates));
                }

                if (e.getKeyCode() == 33) {//PgUp
                    renderer.riseLevelToRender();
                }

                if (e.getKeyCode() == 34) {//PgDown
                    renderer.lowerLevelToRender();
                }

                endTurnAction();    //End turn on movement
            }
            return false;
        }
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }
}
*/
