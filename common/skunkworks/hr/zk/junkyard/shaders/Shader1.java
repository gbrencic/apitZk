package hr.zk.junkyard.shaders;

/**
 * User: gbrencic
 * Date: 02.10.13.
 * Time: 15:52
 */

import org.lwjgl.Sys;
import org.newdawn.slick.*;

/**
 * Lesson 1 from the shader tutorial series on the wiki.
 *
 * @author davedes
 */
public class Shader1 extends BasicGame {
    private Image logo;


    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new Shader1(), 800, 600, false).start();
    }

    public Shader1() {
        super("Shader 1");
    }

    private ShaderProgram program;
    private boolean shaderWorks = false;

    @Override
    public void init(GameContainer container) throws SlickException {
        logo = new Image("common/resources/shaders/logo.png");
        // this test requires shaders
        if (!ShaderProgram.isSupported()) {
            // Sys is part of LWJGL -- it's a handy way to show an alert
            Sys.alert("Error", "Your graphics card doesn't support OpenGL shaders.");
            container.exit();
            return;
        }

        // load our shader program
        try {
            // load our vertex and fragment shaders
            final String VERT = "common/resources/shaders/lesson1.vert";
            final String FRAG = "common/resources/shaders/lesson1.frag";

            program = ShaderProgram.loadProgram(VERT, FRAG);
            program.bind();
            program.setUniform1f("redness", 0.8f);
            shaderWorks = true;
            ShaderProgram.unbindAll();
        } catch (SlickException e) {
            // there was a problem compiling our source! show the log
            e.printStackTrace();
        }
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        //start using our program
        if (shaderWorks)
            program.bind();

        //render our shapes with the shader enabled
        g.fillRect(100, 100, 50, 50);

        g.drawImage(logo, 100, 200);

        //stop using our program
        if (shaderWorks)
            program.unbind();

        g.drawImage(logo, 100, 400);

        String txt = shaderWorks ? "Shader works!" : "Shader did not compile, check log";
        g.drawString(txt, 10, 25);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
    }
}
