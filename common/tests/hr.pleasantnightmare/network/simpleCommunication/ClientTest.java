package hr.pleasantnightmare.network.simpleCommunication;

import pleasantnightmare.network.SocketClient;

/**
 * User: gbrencic
 * Date: 29.08.12.
 * Time: 11:02
 */
public class ClientTest {
    public static void main(String[] args) {
        SocketClient client = new SocketClient("localhost", 9999) {
            @Override
            public void serverMessageRecieved(String message) {
                System.out.println("CLIENT: " + message);
            }
        };
    }
}
