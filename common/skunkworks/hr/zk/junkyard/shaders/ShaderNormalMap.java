package hr.zk.junkyard.shaders;

/**
 * User: gbrencic
 * Date: 02.10.13.
 * Time: 15:52
 */

import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;
import org.newdawn.slick.*;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.FileInputStream;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.GL_TEXTURE1;
import static org.lwjgl.opengl.GL13.glActiveTexture;

/**
 * Lesson 1 from the shader tutorial series on the wiki.
 *
 * @author davedes
 */
public class ShaderNormalMap extends BasicGame {
    public static final Vector3f LIGHT_POS = new Vector3f(0f, 0f, 0.5f);
    private Texture rock;
    private Texture rockNormals;

    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new ShaderNormalMap(), 800, 600, false).start();
    }

    public ShaderNormalMap() {
        super("Shader 1");
    }

    private ShaderProgram program;
    private boolean shaderWorks = false;



    @Override
    public void init(GameContainer container) throws SlickException {
        try {
            rock = TextureLoader.getTexture("png", new FileInputStream("common/resources/shaders/rock.png"));
            rockNormals = TextureLoader.getTexture("png", new FileInputStream("common/resources/shaders/rockNormals.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

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
            final String FRAG = "common/resources/shaders/normal.frag";

            final float DEFAULT_LIGHT_Z = 0.075f;
            final Vector3f LIGHT_POS = new Vector3f(0f, 0f, DEFAULT_LIGHT_Z);
            final Vector4f LIGHT_COLOR = new Vector4f(1f, 0.8f, 0.6f, 1f);
            final Vector4f AMBIENT_COLOR = new Vector4f(0.6f, 0.6f, 1f, 0.2f);
            final Vector3f FALLOFF = new Vector3f(.4f, 3f, 20f);

            program = ShaderProgram.loadProgram(VERT, FRAG);
            program.bind();

            //our normal map
            program.setUniform1i("u_normals", 1); //GL_TEXTURE1

            //light/ambient colors
            program.setUniform2i("Resolution", 1024, 768);
            program.setUniform4f("LightColor", 1f, 0.0f, 0.0f, 1f);
            program.setUniform4f("AmbientColor", 0.6f, 0.0f, 0f, 0.2f);
            program.setUniform3f("Falloff", .4f, 0f, 0f);
            program.setUniform1i("u_texture", 0);
            program.setUniform1i("u_normals", 0);

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

        float x = Mouse.getX() / (float) Display.getWidth();
        float y = Mouse.getY() / (float) Display.getHeight();
        LIGHT_POS.x = x;
        LIGHT_POS.y = y;

        //send a Vector4f to GLSL
        program.setUniform3f("LightPos", 0.8f, 0.8f, 0.3f);

        program.setUniform1i("u_texture", 0);
        glActiveTexture(GL_TEXTURE0);
        glBindTexture(GL_TEXTURE0, rock.getTextureID());

        program.setUniform1i("u_normals", 0);
        glActiveTexture(GL_TEXTURE1);
        glBindTexture(GL_TEXTURE1, rockNormals.getTextureID());


//        glActiveTexture(GL_TEXTURE0);
//        rock.bind();

        //stop using our program
        if (shaderWorks)
            program.unbind();

        String txt = shaderWorks ? "Shader works!" : "Shader did not compile, check log";
        g.drawString(txt, 10, 25);
    }


    @Override
    public void update(GameContainer container, int delta) throws SlickException {
    }
}
