package hr.pleasantnightmare.network.simplechat;

import pleasantnightmare.network.SocketClient;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * User: gbrencic
 * Date: 29.08.12.
 * Time: 10:37
 */
public class ChatClientPanel {
    private JTextArea chatMessageViewArea;
    private JTextArea chatMessageInputArea;
    private JButton sendButton;
    private JButton loginButton;
    private JTextField usernameTextField;
    private JList onlineUsersList;
    private JPanel mainPanel;
    private JButton disconectButton;
    private SocketClient client;

    public ChatClientPanel() {
        client = new SocketClient("localhost", 9999) {
            @Override
            public void serverMessageRecieved(String message) {
                System.out.println("CRCV: " + message);
                chatMessageViewArea.setText(chatMessageViewArea.getText() + message + "\n");
            }
        };

        sendButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String message = usernameTextField.getText() + ": " + chatMessageInputArea.getText();
                client.sendMessageToServer(message);
                chatMessageInputArea.setText("");
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
