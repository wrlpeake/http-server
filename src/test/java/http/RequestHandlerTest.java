package http;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestHandlerTest {
    RequestHandler requestHandler = new RequestHandler();

    @Test
    public void getRequestTest() throws IOException {
        String request = "GET /simple_get HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(request.getBytes());

        assertEquals(request, requestHandler.getRequest(input));
    }
    @Test
    public void getRequestParametersTest() {
        String request = "GET /simple_get HTTP/1.1\r\n";
        String parameters = "GET /simple_get HTTP/1.1";
        assertEquals(parameters, requestHandler.getRequestParameters(request));
    }

    @Test
    public void getMethodTest() {
        String request = "GET /simple_get HTTP/1.1\r\n";
        String parameters = requestHandler.getRequestParameters(request);
        String method = "GET";
        assertEquals(method, requestHandler.getMethod(parameters));
    }

    @Test
    public void getPathTest() {
        String request = "GET /simple_get HTTP/1.1\r\n";
        String parameters = requestHandler.getRequestParameters(request);
        String path = "/simple_get";
        assertEquals(path, requestHandler.getPath(parameters));
    }
}
