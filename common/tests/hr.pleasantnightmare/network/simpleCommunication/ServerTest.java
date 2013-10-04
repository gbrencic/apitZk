package hr.pleasantnightmare.network.simpleCommunication;

import pleasantnightmare.network.Client;
import pleasantnightmare.network.SocketMultiClientServer;

/**
 * User: gbrencic
 * Date: 29.08.12.
 * Time: 11:02
 */
public class ServerTest {
    public static void main(String[] args) {
        SocketMultiClientServer mcs = new SocketMultiClientServer(9999){
//            @Override
          /*  public void update(List<Client> clients, List<String> messages) {
                //TODO Implement ME
            }*/
/*
            @Override
            public void clientMessageRecieved(String message) {
                System.out.println("SERVER: " + message);
            }*/

//            @Override
            public void clientConnected(Client client) {
                System.out.println("Client connected " + client.getId());
            }
        };
    }
}
