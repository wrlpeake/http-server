package http;

import java.io.IOException;
import java.net.ServerSocket;

public class WebServer extends Thread {
    ServerSocket serverSocket;

    public WebServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
   }

   public void run() {
        while (true) {
            try {
                new ClientHandler(this.serverSocket.accept()).start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
   }
}