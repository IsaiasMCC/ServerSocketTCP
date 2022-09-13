
package socket_basic_tcp;

/**
 *
 * @author Isai
 */
public class Socket_Basic_TCP {

    public static void main(String[] args) {
        Server server = new Server(5000);
        server.startServer();
    }
}
