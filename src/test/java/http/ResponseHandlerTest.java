package http;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseHandlerTest {

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

        String status200Response = "HTTP/1.1 200 OK\r\nAllow: GET, HEAD\r\n\r\n";
        assertEquals(status200Response, responseHandler.buildResponse(method, path));
    }

    @Test
    public void getRequestReturns200WithABody() throws IOException {
        String requestParameters = "GET /simple_get_with_body HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String request = requestHandler.getRequest(input);
        String parameters = requestHandler.getRequestParameters(request);
        String method = requestHandler.getMethod(parameters);
        String path = requestHandler.getPath(parameters);

        String status200ResponseWithBody = "HTTP/1.1 200 OK\r\nAllow: GET, HEAD\r\n\r\nHello world";
        assertEquals(status200ResponseWithBody, responseHandler.buildResponse(method, path));
    }

    @Test
    public void simpleHeadRequestToSimpleGet() throws IOException {
        String requestParameters = "HEAD /simple_get HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String request = requestHandler.getRequest(input);
        String parameters = requestHandler.getRequestParameters(request);
        String method = requestHandler.getMethod(parameters);
        String path = requestHandler.getPath(parameters);

        String status200Response = "HTTP/1.1 200 OK\r\nAllow: GET, HEAD\r\n\r\n";
        assertEquals(status200Response, responseHandler.buildResponse(method, path));
    }

    @Test
    public void simpleHeadRequestWithNoBody() throws IOException {
        String requestParameters = "HEAD /head_request HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String request = requestHandler.getRequest(input);
        String parameters = requestHandler.getRequestParameters(request);
        String method = requestHandler.getMethod(parameters);
        String path = requestHandler.getPath(parameters);

        String status200Response = "HTTP/1.1 200 OK\r\nAllow: HEAD, OPTIONS\r\n\r\n";
        assertEquals(status200Response, responseHandler.buildResponse(method, path));
    }

    @Test
    public void methodNotAllowed() throws IOException {
        String requestParameters = "GET /head_request HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String request = requestHandler.getRequest(input);
        String parameters = requestHandler.getRequestParameters(request);
        String method = requestHandler.getMethod(parameters);
        String path = requestHandler.getPath(parameters);

        String status200Response = "HTTP/1.1 405 Method Not Allowed\r\nAllow: HEAD, OPTIONS\r\n\r\n";
        assertEquals(status200Response, responseHandler.buildResponse(method, path));
    }

    @Test
    public void redirect301Test() throws IOException {
        String requestParameters = "GET /redirect HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String request = requestHandler.getRequest(input);
        String parameters = requestHandler.getRequestParameters(request);
        String method = requestHandler.getMethod(parameters);
        String path = requestHandler.getPath(parameters);

        String status200Response = "HTTP/1.1 301 Redirect\r\nLocation: http://127.0.0.1:5000/simple_get\r\nAllow: GET, HEAD\r\n\r\n";
        assertEquals(status200Response, responseHandler.buildResponse(method, path));

    }
    @Test
    public void methodOptionsTest() throws IOException {
        String requestParameters = "OPTIONS /method_options HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String request = requestHandler.getRequest(input);
        String parameters = requestHandler.getRequestParameters(request);
        String method = requestHandler.getMethod(parameters);
        String path = requestHandler.getPath(parameters);

        String status200Response = "HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS\r\n\r\n";
        assertEquals(status200Response, responseHandler.buildResponse(method, path));

    }

}
