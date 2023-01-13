package http;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestHandlerTest {

    @Test
    public void getRequestTest() throws IOException {
        String request = "OPTIONS /method_options2 HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(request.getBytes());

        assertEquals(request, RequestHandler.getRequest(input));
    }
    @Test
    public void getRequestParametersTest() {
        String request = "POST /echo_body HTTP/1.1\r\nContent-Type: text/plain\r\nContent-Length: 7\r\n\r\nSunrise";
        String parameters = "POST /echo_body HTTP/1.1";
        assertEquals(parameters, RequestHandler.getRequestParameters(request));
    }

    @Test
    public void getMethodTest() {
        String request = "GET /foo_bar HTTP/1.1\r\n";
        String parameters = RequestHandler.getRequestParameters(request);
        String method = "GET";
        assertEquals(method, RequestHandler.getMethod(parameters));
    }

    @Test
    public void getPathTest() {
        String request = "HEAD /under_the_sea HTTP/1.1\r\n";
        String parameters = RequestHandler.getRequestParameters(request);
        String path = "/under_the_sea";
        assertEquals(path, RequestHandler.getPath(parameters));
    }

    @Test
    public void getBodyTest() {
        String request = "POST /to_the_moon HTTP/1.1\r\nContent-Type: text/plain\r\nContent-Length: 11\r\n\r\nHello world";
        String expectedBody = "Hello world";
        assertEquals(expectedBody, RequestHandler.getBody(request));
    }
}
