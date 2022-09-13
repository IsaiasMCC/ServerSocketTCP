
package socket_basic_tcp;
import Events.SocketEvent;
import Events.SocketEventListener;
import java.io.*;
import java.net.*;

/**
 *
 * @author Isai
 */
public class Server implements SocketEventListener{
    private ServerSocket serverSocket;
    private ClientListener threadListener;
    private int PORT;
    
    public Server(int port){
        this.PORT = port;
    }
    
    public void startServer(){
        try {
            this.serverSocket = new ServerSocket(this.PORT);
            System.out.println("Server Socket Running");
            this.threadListener = new ClientListener(this.serverSocket);
            this.threadListener.addSocketEventListener(this);
            this.threadListener.start();
        }
        catch(IOException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void onConnectedClient(SocketEvent ev){
        Socket client = ev.getClient();
        System.out.println("Client connected");
        
        DataListener threadDataListener = new DataListener(client);
        threadDataListener.addSocketListener(this);
        threadDataListener.start();
        
    }

    @Override
    public void onDisconnectedClient(SocketEvent ev) {
        System.out.println("Client Disconnect");
    }
    
}
