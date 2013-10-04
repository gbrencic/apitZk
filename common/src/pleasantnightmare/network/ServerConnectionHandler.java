package pleasantnightmare.network;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * User: gbrencic
 * Date: 30.08.12.
 * Time: 12:43
 */
public class ServerConnectionHandler implements Runnable {
    private List<Client> clients = Collections.synchronizedList(new LinkedList<Client>());
    private final int maxConnections = 0;
    private int port = 9999;
    private MessageHandler clientCommunication;
    private final SocketMultiClientServer server;

    public ServerConnectionHandler(SocketMultiClientServer server) {
        this.server = server;
    }

    @Override
    public void run() {
        try {
            ServerSocket listener = new ServerSocket(port);
            int i = 0;
            while ((i++ < maxConnections) || (maxConnections == 0)) {
                try {
                    clientCommunication = new MessageHandler(listener.accept()) {
                        @Override
                        public void messageRecieved(String message) {
                            clientMessageRecieved(message);
                        }

                        @Override
                        public void connectionEstablished(Socket socket, PrintStream output) {
                            System.out.println("Someone connected...");
                            final Client client = new Client(getId(), socket, output);
                            addClient(client);
                            clientConnected(client);
                        }
                    };
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Thread t = new Thread(clientCommunication);
                t.start();
            }
        } catch (IOException ioe) {
            System.out.println("IOException on socket listen: " + ioe);
            ioe.printStackTrace();
        }
    }

    private void addClient(Client client) {
        synchronized (clients) {
            clients.add(client);
        }
    }

    private void clientMessageRecieved(String message) {
        server.clientMessageRecieved(message);
    }


    private void clientConnected(Client client) {
        server.clientConnected(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    private int id = 0;

    private synchronized int getId() {
        id = id + 1;
        return id;
    }
}
