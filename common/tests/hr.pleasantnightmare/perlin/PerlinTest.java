package hr.pleasantnightmare.perlin;

import org.newdawn.slick.*;

import java.util.Random;

/**
 * User: gbrencic
 * Date: 07.06.13.
 * Time: 12:21
 */
public class PerlinTest extends BasicGame {
    private GameContainer gameContainer;
    private Perlin p;
    private float roughness;
    private int seed;

    public PerlinTest(String title) {
        super(title);
        seed = 100;
        Random rand = new Random(seed);
        roughness = 5.0f;
        p = new Perlin(rand, roughness, 300, 300);
        p.initialise();
//        p.printAsMap();
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.gameContainer = gameContainer;
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        //TODO Implement ME
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.setColor(Color.white);
        graphics.drawString("Seed: " + seed, 600, 50);
        graphics.drawString("Roughness: " + roughness, 600, 80);
        graphics.scale(2f, 2f);
        graphics.drawImage(p.getImageMap(), 0, 0);
    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_ESCAPE) {
            gameContainer.exit();
        }

        if (key == Input.KEY_ENTER) {
            Random rand = new Random(seed);
            p = new Perlin(rand, roughness, 300, 300);
            p.initialise();
        }

        if (key == Input.KEY_RIGHT) {
            seed++;
        }
        if (key == Input.KEY_LEFT) {
            seed--;
        }
        if (key == Input.KEY_UP) {
            roughness++;
        }
        if (key == Input.KEY_DOWN) {
            roughness--;
        }

        if (key == Input.KEY_HOME) {
        }
        if (key == Input.KEY_END) {
        }
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new PerlinTest("Perlin test"));
            container.setDisplayMode(1024, 768, false);
            container.setMouseGrabbed(true);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
