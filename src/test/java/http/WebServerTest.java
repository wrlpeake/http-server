package http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebServerTest {

    RequestHandler requestHandler = new RequestHandler();
    ResponseHandler responseHandler = new ResponseHandler();

    @Test
    public void pageNotFoundTestReturnsA404() {
        String requestMethod = "GET";
        String path = "/hello_world";
        String pageNotFoundResponse = "HTTP/1.1 404 Not Found";

        String request = requestHandler.parseRequest(requestMethod, path);
        assertEquals(pageNotFoundResponse, responseHandler.getStringResponse(pageNotFoundResponse));
    }

}
