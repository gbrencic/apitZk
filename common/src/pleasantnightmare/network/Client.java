package pleasantnightmare.network;

import java.io.PrintStream;
import java.net.Socket;

/**
 * User: gbrencic
 * Date: 29.08.12.
 * Time: 13:30
 */
public class Client {
    private int id = -1;
    private Socket socket;
    private PrintStream output;

    public Client(int id, Socket socket, PrintStream output) {
        this.id = id;
        this.socket = socket;
        this.output = output;
    }

    public int getId() {
        return id;
    }

    public Socket getSocket() {
        return socket;
    }

    public void sendMessage(String message) {
        output.println(message);
    }
}
