
package Events;
import java.util.EventListener;
/**
 *
 * @author Isai
 */
public interface SocketEventListener extends EventListener {
    public void onConnectedClient( SocketEvent ev);
    public void onDisconnectedClient( SocketEvent ev);
}
