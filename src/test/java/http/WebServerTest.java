package http;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebServerTest {
    WebServer webServer;
    TestClient client;

    @BeforeEach
    public void setup() throws IOException {
        webServer = new WebServer(5000);
        client = new TestClient(5000);
    }


    @Test
    public void pageNotFoundTestReturnsA404() throws IOException {
        client.start();
        webServer.start();
        String requestParameters = "GET /a_cat HTTP/1.1";
        String pageNotFoundResponse = "HTTP/1.1 404 Not Found";
        assertEquals(pageNotFoundResponse, client.sendAndReceiveMessage(requestParameters));
    }

}
