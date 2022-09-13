package socket_basic_tcp;

import Events.SocketEvent;
import Events.SocketEventListener;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isai
 */
public class ClientListener extends Thread {

    private ServerSocket socket;
    private Socket client;
    public List<SocketEventListener> listeners;
    public boolean state;

    public ClientListener(ServerSocket socket) {
        this.socket = socket;
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
                this.client = this.socket.accept();
                dispatcherOnconnectedClient(this.socket, this.client);
                
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            
        }
    }
    
    private void dispatcherOnconnectedClient(ServerSocket socket, Socket client){
        SocketEvent obj = new SocketEvent(this, socket, client);
        for(SocketEventListener e : listeners)
            e.onConnectedClient(obj);
    }
    
    public void addSocketEventListener(SocketEventListener listener){
        this.listeners.add(listener);
    }
    
    public void finishThread(){
        this.state = false;
    }
}
