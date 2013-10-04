package hr.pleasantnightmare;

import zk_old.entity.Entity;
import zk_old.entity.creatures.BasicPlayer;
import zk_old.entity.creatures.DarkCreature;
import zk_old.entity.creatures.LightCreature;
import zk_old.entity.inanimate.Tree;
import zk_old.entity.spawning.DarkCreatureSpawnPoint;
import zk_old.entity.weapons.Bomb;
import zk_old.entity.weapons.Bullet;
import zk_old.entity.weapons.Granade;
import zk_old.game.TurnCounter;
import zk_old.game.engine.RegenerationEffect;
import zk_old.graphic.ImageRenderer;
import pleasantnightmare.movment.Coordinates;
import pleasantnightmare.movment.Movement;
import zk_old.stage.BaseMap;
import zk_old.stage.BaseMapFactory;
import zk_old.stage.MapDimensions;
import zk_old.stage.Stage;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * User: gbrencic
 * Date: 22.08.12.
 * Time: 15:27
 */
public class FtlMainTest extends BasicGame {
    private ImageRenderer renderer;
    private Stage stage;
    private Entity player;
    private TurnCounter turnCounter;

    private GameContainer gameContainer;
    final int xSize = 250;
    final int ySize = 250;
    private int[][] map;

    public FtlMainTest() {
        super("FtlMainTest");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.gameContainer = gameContainer;

        BaseMap map = BaseMapFactory.getSquareMap(new MapDimensions(xSize, ySize, 3));
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
        stage.addEntityBeforeUpdate(lightCreature);

        stage.addEntityBeforeUpdate(new DarkCreature(new Coordinates(2, 2)));
        stage.addEntityBeforeUpdate(new DarkCreatureSpawnPoint(new Coordinates(4, 4), stage));

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new KeyboardInputDispatcher());
        turnCounter = new TurnCounter() {
            @Override
            public void endTurn() {
                endTurnAction();
            }
        };

        //for (int i = 0; i < 10000; i++) {

        renderer = new ImageRenderer();

        endTurnAction();
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
       // endTurnAction();
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.scale(5f, 5f);
        graphics.drawImage(renderer.getImage(), 30, 30);
    }

    private int[][] generateMap() {
        map = null;

        map = new int[xSize + 1][ySize + 1];
        for (int t = 0; t < 20; t++) {
            createMountains(map);
            createHoles(map);
        }

        return map;
    }

    private void createHoles(int[][] map) {
        int xPos = getRandInt(xSize - 1);
        int yPos = getRandInt(ySize - 1);
        final int size = getRandInt(50);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 50; j++) {
                if ((xPos + i) <= xSize && (yPos + j) <= ySize)
                    map[xPos + i][yPos + j] = map[xPos + i][yPos + j] - getRandInt(50) - 50;
            }
        }
    }

    private void createMountains(int[][] map) {
        int xPos = getRandInt(xSize - 1);
        int yPos = getRandInt(ySize - 1);

        final int size = getRandInt(50);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((xPos + i) <= xSize && (yPos + j) <= ySize)
                    map[xPos + i][yPos + j] = map[xPos + i][yPos + j] + getRandInt(50) + 50;
            }
        }
    }

    public int getRandInt(int numberMax) {
        Random rand = new Random();
        return rand.nextInt(numberMax);
    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_ESCAPE) {
            gameContainer.exit();
        }

        if (key == Input.KEY_ENTER) {
//            generateMap();
        }

        Movement movement = player.getMovement();

        if (key == Input.KEY_RIGHT) {
            movement.moveRight();
        }
        if (key == Input.KEY_LEFT) {
            movement.moveLeft();
        }
        if (key == Input.KEY_UP) {
            movement.moveUp();
        }
        if (key == Input.KEY_DOWN) {
            movement.moveDown();
        }

        if (key == Input.KEY_HOME) {
            movement.riseLevel();
        }
        if (key == Input.KEY_END) {
            movement.loverLevel();
        }

        if (key == Input.KEY_SPACE) {//Space
            Coordinates coordinates = new Coordinates(movement.getEndPosition());
            coordinates.setX(coordinates.getX() + 1);
            stage.addEntityBeforeUpdate(new Bomb(coordinates));
        }

        if (key == Input.KEY_LCONTROL) {//LCtrl
            Coordinates coordinates = new Coordinates(movement.getEndPosition());
            coordinates.setX(coordinates.getX() + 1);
            stage.addEntityBeforeUpdate(new Bullet(coordinates));
        }

        if (key == Input.KEY_LALT) {//LAlt
            Coordinates coordinates = new Coordinates(movement.getEndPosition());
            coordinates.setX(coordinates.getX() + 1);
            stage.addEntityBeforeUpdate(new Granade(coordinates));
        }

        if (key == Input.KEY_INSERT) {//PgUp
            renderer.riseLevelToRender();
        }

        if (key == Input.KEY_DELETE) {//PgDown
            renderer.lowerLevelToRender();
        }

        endTurnAction();
    }

    public static void main(String[] args) {
        try {
                    AppGameContainer container = new AppGameContainer(new FtlMainTest());
                    container.setDisplayMode(800, 600, false);
                    container.setMouseGrabbed(true);
                    container.start();
                } catch (SlickException e) {
                    e.printStackTrace();
                }
    }

    public void endTurnAction() {
        turnCounter.nextTurn();
        stage.endTurnUpdate();
        renderer.drawMap(stage.getMap(), player.getCoordinates());

        //Build info screen
        String info = String.valueOf("Turn:" + turnCounter.getTurn());
        /*    InfoMessageBuffer.addInfoMessage(info);
        InfoMessageBuffer.addInfoMessage("Entites: " + stage.getEntityList().size());
        gameScreen.getInfoLabel().setText(InfoMessageBuffer.getInfoMessages());
        gameScreen.getStatusLabel().setText(" HP: " + player.getStatus().getHp());

        InfoMessageBuffer.clearInfoMessages();*/
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
}
