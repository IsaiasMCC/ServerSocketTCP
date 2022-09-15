
package Events;
import extras.ClientConnection;
import java.net.*;
import java.util.EventObject;

/**
 *
 * @author Isai
 */
public class SocketEvent extends EventObject{
    private ServerSocket socket;
    private Socket client;
    private ClientConnection eventClient;
    
    public SocketEvent(Object source ,ServerSocket _socket, Socket _client, String id, String nick, String password){
        super(source);
        this.socket = _socket;
        this.client = _client;
        this.eventClient = new ClientConnection(id, nick, password);
    }
    
    public ServerSocket getSocket(){
        return this.socket;
    }
    public Socket getClient(){
        return this.client;
    }
    public ClientConnection getEventClient(){
        return this.eventClient;
    }
}
