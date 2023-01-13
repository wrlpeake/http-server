package http;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestHandlerTest {

    @Test
    public void getRequestTest() throws IOException {
        String request = "GET /simple_get HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(request.getBytes());

        assertEquals(request, RequestHandler.getRequest(input));
    }
    @Test
    public void getRequestParametersTest() {
        String request = "GET /simple_get HTTP/1.1\r\n";
        String parameters = "GET /simple_get HTTP/1.1";
        assertEquals(parameters, RequestHandler.getRequestParameters(request));
    }

    @Test
    public void getMethodTest() {
        String request = "GET /simple_get HTTP/1.1\r\n";
        String parameters = RequestHandler.getRequestParameters(request);
        String method = "GET";
        assertEquals(method, RequestHandler.getMethod(parameters));
    }

    @Test
    public void getPathTest() {
        String request = "GET /simple_get HTTP/1.1\r\n";
        String parameters = RequestHandler.getRequestParameters(request);
        String path = "/simple_get";
        assertEquals(path, RequestHandler.getPath(parameters));
    }

    @Test
    public void getBodyTest() {
        String request = "GET /echo_body HTTP/1.1\r\nContent-Type: text/plain\r\nContent-Length: 11\r\n\r\nHello world";
        String expectedBody = "Hello world";
        assertEquals(expectedBody, RequestHandler.getBody(request));
    }
}
