package pleasantnightmare.network;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * User: gbrencic
 * Date: 02.04.12.
 * Time: 12:00
 */
public abstract class SocketMultiClientServer {
    private final ServerConnectionHandler connectionHandler = new ServerConnectionHandler(this);
    //    private List<String> messages = Collections.synchronizedList(new LinkedList<String>());
    private ConcurrentLinkedQueue<String> messages = new ConcurrentLinkedQueue<String>();

    public SocketMultiClientServer(final int port) {
        System.out.println("Starting server...");

        Thread t = new Thread(connectionHandler);
        t.start();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    /*  System.out.println(messages.size());
                    final LinkedList<String> msgs = new LinkedList<String>(messages);
                    messages.clear();*/
                    update(connectionHandler.getClients(), messages);

                }
            }
        });
        t1.start();

        System.out.println("Server Started...");
    }

    public void update(List<Client> clients, ConcurrentLinkedQueue<String> messages) {
    }

    public abstract void clientConnected(Client client);

    public void clientMessageRecieved(String message) {
        synchronized (messages) {
            messages.add(message);
        }
    }

    public void removeMessage(String message) {
        synchronized (messages) {
            messages.remove(message);
        }
    }

    public synchronized ConcurrentLinkedQueue<String> getMessages() {
        synchronized (messages) {
            return messages;
        }
    }

    public List<Client> getClients() {
        return connectionHandler.getClients();
    }
}
