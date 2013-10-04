package pleasantnightmare.network;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * User: gbrencic
 * Date: 02.04.12.
 * Time: 11:04
 */
public abstract class SocketClient {
    private Socket serverSocket;
    private MessageHandler serverCommunication;

    public SocketClient(String server, int port) {
        try {
            serverSocket = new Socket(server, port);
            serverCommunication = new MessageHandler(serverSocket) {
                @Override
                public void messageRecieved(String message) {
                    serverMessageRecieved(message);
                }

                @Override
                public void connectionEstablished(Socket socket, PrintStream output) {   //Tu ne treba output...
                    System.out.println("I connected...");
                }
            };

            Thread t = new Thread(serverCommunication);
            t.start();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void serverMessageRecieved(String message);

    public void sendMessageToServer(String message) {
        serverCommunication.sendMessage(message);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
