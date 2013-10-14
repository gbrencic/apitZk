package hr.zk.common.resources.graphic;

import org.newdawn.slick.*;

/**
 * User: gbrencic
 * Date: 04.10.13.
 * Time: 11:50
 */
public class GraphicsLoaderUsage extends BasicGame {
    private GameContainer gameContainer;
    //    private GraphicsFactory spriteFactory;
    private GraphicsLoader graphicsLoader;
    private Animation animation;
    private Animation animationLeft;

    public GraphicsLoaderUsage() {
        super("Sprite factory test");
        GraphicsLoaderFactory gf = new DefaultGraphicsLoaderFactory();
        graphicsLoader = gf.create("common/resources/sprites/");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.gameContainer = gameContainer;
        //Load resources
        graphicsLoader.loadImage("mario_simple.png");
        graphicsLoader.loadPackedSpriteSheet("mario_simple");
        graphicsLoader.loadAnimation("marioWalk", "mario_simple", "mario_simple", 1, 4, 200);
        graphicsLoader.loadHorizontaliyFlippedAnimation("marioWalkLeft", "mario_simple", "mario_simple", 1, 4, 200);

        animation = graphicsLoader.getAnimation("marioWalk");
        animation.setPingPong(true);

        animationLeft = graphicsLoader.getAnimation("marioWalkLeft");
        animationLeft.setPingPong(true);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        animation.update(delta);  //Mora updejtati ina ce ne prati deltu
        animationLeft.update(delta);  //Mora updejtati ina ce ne prati deltu
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        //Static image
        graphics.drawImage(graphicsLoader.getImage("mario_simple.png"), 20, 30);

        // draw animation
        animation.draw(20, 280);
        graphics.drawAnimation(animation, 20, 250);

        // draw animation
        animationLeft.draw(60, 280);

    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_ESCAPE) {
            gameContainer.exit();
        }
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new GraphicsLoaderUsage());
            container.setDisplayMode(800, 600, false);
//            container.setTargetFrameRate(60);
//            container.setMouseGrabbed(true);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
