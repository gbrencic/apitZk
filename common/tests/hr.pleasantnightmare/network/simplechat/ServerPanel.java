package hr.pleasantnightmare.network.simplechat;

import pleasantnightmare.network.Client;
import pleasantnightmare.network.SocketMultiClientServer;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * User: gbrencic
 * Date: 29.08.12.
 * Time: 10:58
 */
public class ServerPanel {
    private JPanel mainPanel;
    private JList onlineUsersList;
    private JButton startButton;
    private JButton stopButton;
    private SocketMultiClientServer server;

    public ServerPanel() {
        server = new SocketMultiClientServer(9999) {
           /* @Override
            public void update(List<Client> clients, List<String> messages) {
                //TODO Implement ME
            }*/

           /* @Override
            public void clientMessageRecieved(String message) {
                System.out.println("SRCV: " + message);

                for (Client client : getConnections()) {       //Pošalji svima sto je netko napisao
                    client.sendMessage(message);
                }
            }
*/
            @Override
            public void clientConnected(Client client) {
                System.out.println("Client connected: " + client.getId());
            }
        };


        startButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        stopButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Stop recv connections");
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
