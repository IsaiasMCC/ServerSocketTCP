
package Events;
import java.net.*;
import java.util.EventObject;

/**
 *
 * @author Isai
 */
public class SocketEvent extends EventObject{
    private ServerSocket socket;
    private Socket client;
    
    public SocketEvent(Object source ,ServerSocket _socket, Socket _client){
        super(source);
        this.socket = _socket;
        this.client = _client;
    }
    
    public ServerSocket getSocket(){
        return this.socket;
    }
    public Socket getClient(){
        return this.client;
    }
}
