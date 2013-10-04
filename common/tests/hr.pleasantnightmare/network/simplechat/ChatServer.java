package hr.pleasantnightmare.network.simplechat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * User: gbrencic
 * Date: 29.08.12.
 * Time: 10:56
 */
public class ChatServer {
    public ChatServer() {
        ServerPanel serverPanel = new ServerPanel();
        createMainFrame(serverPanel);
    }

    private JFrame createMainFrame(ServerPanel serverPanel) {
        JFrame mainFrame = new JFrame("Server v0.1");
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("ON APPLICATION CLOSE EVENT");
            }
        });
        mainFrame.setContentPane(serverPanel.getMainPanel());
        mainFrame.setMinimumSize(new Dimension(500, 400));

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //TODO do nothing on close
        mainFrame.setLocation(0, 0);
        mainFrame.setVisible(true);
        return mainFrame;
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}
