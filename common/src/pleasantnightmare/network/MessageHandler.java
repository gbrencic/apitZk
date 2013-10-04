package pleasantnightmare.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * User: gbrencic
 * Date: 02.04.12.
 * Time: 12:01
 */
public abstract class MessageHandler implements Runnable {
    private final Socket serverSocket;
    private final BufferedReader input;
    private final PrintStream output;

    private String line;

    MessageHandler(Socket socket) throws IOException {
        this.serverSocket = socket;
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintStream(socket.getOutputStream());
        connectionEstablished(socket, output);
    }

    public void run() {
        try {
            //READ
            while ((line = input.readLine()) != null && !line.equals("<END>")) {
                messageRecieved(line);
            }

            serverSocket.close();
        } catch (IOException ioe) {
            System.out.println("IOException on socket listen: " + ioe);
            ioe.printStackTrace();
        }
    }

    public abstract void messageRecieved(String message);

    public abstract void connectionEstablished(Socket socket, PrintStream output);

    public void sendMessage(String message) {
        output.println(message);
        output.flush();  //Treba li?
    }
}