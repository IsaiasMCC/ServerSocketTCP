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
    private List<DataEventListener> listeners;
    private boolean state;

    public DataListener(Socket client) {
        this.client = client;
        this.listeners = new ArrayList<DataEventListener>();
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
                String inputMessage = null;
                while ((inputMessage = inputStream.readLine()) != null) {
                    dispatcherOnRead(inputMessage);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } finally {
                try {
                    System.out.println("close");
                    this.inputStream.close();
                    //this.client.close();
                    this.state = false;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }

        }
    }

    public void addDataListener(DataEventListener listener) {
        this.listeners.add(listener);
    }

    public void dispatcherOnRead(String data) {
        DataEvent obj = new DataEvent(this, data);
        for (DataEventListener e : listeners) {
            e.OnRead(obj);
        }
    }
}
