package hr.zk.common.entity.state;

import hr.zk.common.application.ApplicationContext;
import hr.zk.common.entity.DefaultRoles;
import hr.zk.common.entity.DefaultStatefulEntity;
import hr.zk.common.entity.state.behaviour.ControlBehaviour;
import hr.zk.common.entity.state.behaviour.ControlBehaviourTest;
import hr.zk.common.resources.graphic.DefaultGraphicsLoaderFactory;
import hr.zk.common.resources.graphic.GraphicsLoader;
import hr.zk.common.resources.graphic.GraphicsLoaderFactory;
import org.newdawn.slick.*;

import static hr.zk.common.entity.state.behaviour.ControlBehaviourAction.*;

/**
 * User: gbrencic
 * Date: 04.10.13.
 * Time: 11:50
 */
public class EntityStateBasicGameTest extends BasicGame {
    final ApplicationContext app = new ApplicationContext();
    private GameContainer gameContainer;
    private GraphicsLoader graphicsLoader;

    private DefaultStatefulEntity player;
    private boolean right; //TODO ca odavdje

    public EntityStateBasicGameTest() {
        super("Entity State test");
        GraphicsLoaderFactory gf = new DefaultGraphicsLoaderFactory();
        graphicsLoader = gf.create("common/resources/sprites/");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.gameContainer = gameContainer;
        graphicsLoader.loadPackedSpriteSheet("mario_simple");
        graphicsLoader.loadAnimation("marioWalkRight", "mario_simple", "mario_simple", 1, 4, 200);
        graphicsLoader.loadHorizontaliyFlippedAnimation("marioWalkLeft", "mario_simple", "mario_simple", 1, 4, 200);

        graphicsLoader.loadAnimation("marioStandRight", "mario_simple", "mario_simple", 1, 1, 10000);
        graphicsLoader.loadHorizontaliyFlippedAnimation("marioStandLeft", "mario_simple", "mario_simple", 1, 1, 10000);

        //Player
        player = new DefaultStatefulEntity(1l, "Player", 100f, 100f, DefaultRoles.PLAYER);

        //Control
        final ControlBehaviour controlBehaviourNormal = new ControlBehaviourTest(player, app, 100);

        //State
        final EntityState normalState = new DefaultTestStateImpl("normal");
        normalState.addBehaviour(controlBehaviourNormal);
        normalState.addBehaviour(new ControlBehaviourTest(player, app, 20));

        player.addState(normalState);
        player.setSelectedState("normal");

        //Resources
        Animation animation = graphicsLoader.getAnimation("marioWalkRight");
        animation.setPingPong(true);
        player.addGraphics("right", animation);

        animation = graphicsLoader.getAnimation("marioWalkLeft");
        animation.setPingPong(true);
        player.addGraphics("left", animation);

        player.addGraphics("standRight", graphicsLoader.getAnimation("marioStandRight"));
        player.addGraphics("standLeft", graphicsLoader.getAnimation("marioStandLeft"));
        player.setSelectedGraphic("standRight");
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        movePlayer(gameContainer, delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawAnimation(player.getSelectedGraphics(), player.getPosX(), player.getPosY());

    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_ESCAPE) {
            gameContainer.exit();
        }
    }

    private void movePlayer(GameContainer gameContainer, int delta) {
        boolean moving = false; //Treba resetrati
        Input input = gameContainer.getInput();

        if (input.isKeyDown(Input.KEY_LEFT)) {
            player.getSelectedState().doAction(LEFT, delta);
            moving = true;
            right = false;
        }

        if (input.isKeyDown(Input.KEY_RIGHT)) {
            player.getSelectedState().doAction(RIGHT, delta);
            moving = true;
            right = true;  //TODO malo drukcije rijesiti sdirection recimo u entitet
        }

        if (input.isKeyDown(Input.KEY_UP)) {
            player.getSelectedState().doAction(UP, delta);
            moving = true;
        }

        if (input.isKeyDown(Input.KEY_DOWN)) {
            player.getSelectedState().doAction(DOWN, delta);
            moving = true;
        }

        if (!moving && right) {
            player.setSelectedGraphic("standRight");
        } else if (!moving && !right) {
            player.setSelectedGraphic("standLeft");
        }

        player.getSelectedGraphics().update(delta);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new EntityStateBasicGameTest());
            container.setDisplayMode(1024, 768, false);
            container.setMouseGrabbed(true);
            container.setFullscreen(true);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
