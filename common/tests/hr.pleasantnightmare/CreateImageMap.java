package hr.pleasantnightmare;

import org.newdawn.slick.*;

import java.util.Random;

/**
 * User: gbrencic
 * Date: 22.08.12.
 * Time: 15:27
 */
public class CreateImageMap extends BasicGame {
    private GameContainer gameContainer;
    private Image image;
    final int xSize = 250;
    final int ySize = 250;
    private ImageBuffer buffer;
    private int[][] map;

    public CreateImageMap() {
        super("ImageMap2");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.gameContainer = gameContainer;

        buffer = new ImageBuffer(xSize, ySize);
        image = buffer.getImage();
        map = generateMap();
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                int val = map[x][y];

                buffer.setRGBA(x, y, val, val, val, 255);

               /* if (val == 0)
                    buffer.setRGBA(x, y, 0, 255, 0, 255);
                else if (val > 0 && val < 50)
                    buffer.setRGBA(x, y, 0, 255, 0, 255);
                else if (val > 50 && val < 255)
                    buffer.setRGBA(x, y, 200, 200, 200, 255);
                else if (val < 0)
                    buffer.setRGBA(x, y, 0, 0, 255, 255);*/
            }
        }

        image = buffer.getImage();
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

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.scale(2f, 2f);
        graphics.drawImage(image, 30, 30);
    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_ESCAPE) {
            gameContainer.exit();
        }

        if (key == Input.KEY_ENTER) {
            generateMap();
        }
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new CreateImageMap());
            container.setDisplayMode(800, 600, false);
            container.setMouseGrabbed(true);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    /* public static void main(String[] args) {
        //   Image image = new Image();
        BufferedImage image = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);

        int[] imagePixelData = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();


        // main loop start
        while (true) {


            /// do stuff...


            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {

                    // get red, green, blue components however you like

                    imagePixelData[y * width + x] = red << 16 | green << 8 | blue;
                }
            }


            // get graphic object of swing component to draw on and draw the image
            g.drawImage(image, 0, 0, null);

            // go back to start of main loop
        }
    }*/   //ImageBuffer
}
