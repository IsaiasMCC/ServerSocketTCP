package socket_basic_tcp;

import java.io.*;
import java.net.*;
import java.util.*;

import Events.*;

/**
 *
 * @author Isai
 */
public class DataListener extends Thread {

    private Socket client;
    private BufferedReader inputStream;
    private List<SocketEventListener> listeners;
    private boolean state;

    public DataListener(Socket client) {
        this.client = client;
        this.listeners = new ArrayList<SocketEventListener>();
        this.state = true;
    }

    @Override
    public void run() {
        startThread();
    }

    private void startThread() {
        while (state) {
            try {
                this.inputStream = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
                String inputLine;
                while ((inputLine = inputStream.readLine()) != null) {
                    if ("end".equals(inputLine) || inputStream.read() == -1){
                        break;
                    }
                }
                dispatcherOnDisconnectedClient(client);
                
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            finally {
                
                    System.out.println("sdjkfljsdklfjsdfklsjdf");
                    //this.client.close();
                    this.state = false;
                

            }

        }
    }
    
    public void addSocketListener(SocketEventListener listener){
        this.listeners.add(listener);
    }
    
    public void dispatcherOnDisconnectedClient(Socket client){
        SocketEvent obj = new SocketEvent(this, null, client);
        for(SocketEventListener e: listeners)
            e.onConnectedClient(obj);
    }
}
