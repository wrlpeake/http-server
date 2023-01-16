package http;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        HTTPServer httpServer = new HTTPServer(5000);
        httpServer.start();
    }
}
