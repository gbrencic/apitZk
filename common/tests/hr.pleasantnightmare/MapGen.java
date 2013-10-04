package hr.pleasantnightmare;

import java.applet.Applet;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

/*
simple Island generator by Damocles
*/

public class MapGen extends Applet implements Runnable {

    static int wide = 1000;
    static int high = 800;

    public void start() {
        new Thread(this).start();
    }

    public void run() {
        while (!this.isActive())
            Thread.yield();

        setSize(wide, high);
        Random ran = new Random();

        BufferedImage image = new BufferedImage(wide, high, BufferedImage.TYPE_INT_RGB);

        int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        double[][] map = new double[wide][high];


        int iterator = 1;
        int stepsize = wide / 16;
        do {
            for (int y = stepsize; y <= high - stepsize * 2; y += stepsize) {
                for (int x = stepsize; x <= wide - stepsize * 2; x += stepsize) {
                    //apply random offset (tweak this)
                    int val = ran.nextInt(40 + iterator * 2) - 20 - iterator * 1;

                    //initial features
                    int valFirst = 50 + ran.nextInt(200);

                    for (int yy = 0; yy < stepsize; yy++) {
                        for (int xx = 0; xx < stepsize; xx++) {
                            if (iterator == 1) map[x + xx][y + yy] = valFirst;
                            else {

                                //apply random value
                                map[x + xx][y + yy] += val;

                                //average out
                                map[x + xx][y + yy] =
                                        (map[x + xx][y + yy] * 2 +
                                                map[x + stepsize + xx][y + yy] +
                                                map[x - stepsize + xx][y + yy] +
                                                map[x + xx][y + yy + stepsize] +
                                                map[x + xx][y + yy - stepsize] +

                                                map[x + stepsize + xx][y + yy + stepsize] +
                                                map[x + stepsize + xx][y + yy - stepsize] +
                                                map[x - stepsize + xx][y + yy + stepsize] +
                                                map[x - stepsize + xx][y + yy - stepsize]

                                        ) / 10;
                            }
                            if (map[x + xx][y + yy] > 255) map[x + xx][y + yy] = 255;
                            if (map[x + xx][y + yy] < 0) map[x + xx][y + yy] = 0;

                        }
                    }
                }
            }

            iterator++;
            stepsize /= 2;

        } while (stepsize > 0);


        //smoothing
        for (int passes = 0; passes < 10; passes++) {


            for (int y = 1; y < high - 1; y++) {
                for (int x = 1; x < wide - 1; x++) {

                    map[x][y] =
                            (
                                    map[x][y] * 2 +
                                            map[x + 1][y] +
                                            map[x - 1][y] +
                                            map[x][y + 1] +
                                            map[x][y - 1] +

                                            map[x + 1][y + 1] +
                                            map[x + 1][y - 1] +
                                            map[x - 1][y + 1] +
                                            map[x - 1][y - 1]

                            ) / 10;
                }
            }
        }


        for (int i = 0; i < pixels.length; i++) {
            //make water
            pixels[i] = 0x40A0FF;

            int mv = (int) map[i % wide][i / wide];
            int mvRB = (int) (map[i % wide][i / wide] * 0.5);  //make Red and Blue darker
            if (mvRB > 255) mvRB = 255;

            if (mv > 140) {
                pixels[i] = (mvRB << 16) | (mv << 8) | mvRB;
                if (mv < 152) pixels[i] = 0xE0D090;  //beach
            }

        }

        while (isActive()) {
            this.getGraphics().drawImage(image, 0, 0, null);
            Thread.yield();
        }
    }


    /*int scanline_count = 224;
    int s_size = screen_height / scanline_count;

    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.1f));
    g.setColor(new

    Color(0,0,0)

    );
    for(
    int i = 0;
    i<screen_height;i++)

    {
        if (i % s_size == 0) {
            g.drawLine(0, i, screen_width, i);
        }
    }*/

}