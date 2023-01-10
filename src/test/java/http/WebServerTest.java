package http;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebServerTest {

    static RequestHandler requestHandler;
    static ResponseHandler responseHandler;

    @BeforeAll
    public static void setup() {
        requestHandler = new RequestHandler();
        responseHandler = new ResponseHandler();
    }


    @Test
    public void pageNotFoundTestReturnsA404() throws IOException {
        String requestParameters = "GET /a_cat HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String request = requestHandler.getRequest(input);
        String parameters = requestHandler.getRequestParameters(request);
        String method = requestHandler.getMethod(parameters);
        String path = requestHandler.getPath(parameters);

        String pageNotFoundResponse = "HTTP/1.1 404 Not Found\r\n\r\n";
        assertEquals(pageNotFoundResponse, responseHandler.buildResponse(method, path));
    }

    @Test
    public void getRequestToSimpleGetReturnsA200() throws IOException {
        String requestParameters = "GET /simple_get HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String request = requestHandler.getRequest(input);
        String parameters = requestHandler.getRequestParameters(request);
        String method = requestHandler.getMethod(parameters);
        String path = requestHandler.getPath(parameters);

        String status200Response = "HTTP/1.1 200 OK\r\n\r\n";
        assertEquals(status200Response, responseHandler.buildResponse(method, path));
    }

}
