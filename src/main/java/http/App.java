package http;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        WebServer webServer = new WebServer(5000);
        webServer.start();
    }
}
