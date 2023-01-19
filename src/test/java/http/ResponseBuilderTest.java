package http;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseBuilderTest {
    static Router router;

    public ResponseBuilderTest() {
        router = new Router();
    }

    public static String responseBuilderHelper(InputStream input) throws IOException {
        Request request = new RequestParser()
                .withRequest(input)
                .withParameters()
                .withMethod()
                .withPath()
                .withBody()
                .parse();

        Response response = router.getResponse(request.getMethod(), request.getPath(), request.getBody());
        return response.responseString();
    }

    @Test
    public void pageNotFoundTestReturnsA404() throws IOException {
        String requestParameters = "GET /a_cat HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String response = ResponseBuilderTest.responseBuilderHelper(input);

        String status404Response = "HTTP/1.1 404 Not Found\r\n\r\n";
        assertEquals(status404Response, response);
    }

    @Test
    public void getRequestToSimpleGetReturnsA200() throws IOException {
        String requestParameters = "GET /simple_get HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String response = ResponseBuilderTest.responseBuilderHelper(input);

        String status200Response = "HTTP/1.1 200 OK\r\nAllow: GET, HEAD\r\n\r\n";
        assertEquals(status200Response, response);
    }

    @Test
    public void getRequestReturns200WithABody() throws IOException {
        String requestParameters = "GET /simple_get_with_body HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String response = ResponseBuilderTest.responseBuilderHelper(input);

        String status200ResponseWithBody = "HTTP/1.1 200 OK\r\nAllow: GET, HEAD\r\n\r\nHello world";
        assertEquals(status200ResponseWithBody, response);
    }

    @Test
    public void simpleHeadRequestToSimpleGet() throws IOException {
        String requestParameters = "HEAD /simple_get HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String response = ResponseBuilderTest.responseBuilderHelper(input);

        String status200Response = "HTTP/1.1 200 OK\r\nAllow: GET, HEAD\r\n\r\n";
        assertEquals(status200Response, response);
    }

    @Test
    public void simpleHeadRequestWithNoBody() throws IOException {
        String requestParameters = "HEAD /head_request HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String response = ResponseBuilderTest.responseBuilderHelper(input);

        String status200Response = "HTTP/1.1 200 OK\r\nAllow: HEAD, OPTIONS\r\n\r\n";
        assertEquals(status200Response, response);
    }

    @Test
    public void methodNotAllowed() throws IOException {
        String requestParameters = "GET /head_request HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String response = ResponseBuilderTest.responseBuilderHelper(input);

        String status405Response = "HTTP/1.1 405 Method Not Allowed\r\nAllow: HEAD, OPTIONS\r\n\r\n";
        assertEquals(status405Response, response);
    }

    @Test
    public void redirect301Test() throws IOException {
        String requestParameters = "GET /redirect HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String response = ResponseBuilderTest.responseBuilderHelper(input);

        String status301Response = "HTTP/1.1 301 Redirect\r\nLocation: http://127.0.0.1:5000/simple_get\r\nAllow: GET, HEAD\r\n\r\n";
        assertEquals(status301Response, response);

    }
    @Test
    public void methodOptionsTest() throws IOException {
        String requestParameters = "OPTIONS /method_options HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String response = ResponseBuilderTest.responseBuilderHelper(input);

        String status200Response = "HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS\r\n\r\n";
        assertEquals(status200Response, response);

    }
    @Test
    public void methodOptions2Test() throws IOException {
        String requestParameters = "OPTIONS /method_options2 HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String response = ResponseBuilderTest.responseBuilderHelper(input);

        String status200Response = "HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n";
        assertEquals(status200Response, response);
    }

    @Test
    public void simplePostEchoesBodyTest() throws IOException {
        String requestParameters = "POST /echo_body HTTP/1.1\r\nContent-Type: text/plain\r\nContent-Length: 11\r\n\r\nHello world";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String response = ResponseBuilderTest.responseBuilderHelper(input);

        String status200ResponseWithBody = "HTTP/1.1 200 OK\r\nAllow: POST\r\n\r\nHello world";
        assertEquals(status200ResponseWithBody, response);
    }

    @Test
    public void textResponseTest() throws IOException {
        String requestParameters = "GET /text_response HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String response = ResponseBuilderTest.responseBuilderHelper(input);

        String status200ResponseWithText = "HTTP/1.1 200 OK\r\nContent-Type: text/plain;charset=utf-8\r\nAllow: GET, HEAD\r\n\r\ntext response";
        assertEquals(status200ResponseWithText, response);
    }

    @Test
    public void HTMLResponseTest() throws IOException {
        String requestParameters = "GET /html_response HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestParameters.getBytes());

        String response = ResponseBuilderTest.responseBuilderHelper(input);

        String status200ResponseWithHTML = "HTTP/1.1 200 OK\r\nContent-Type: text/html;charset=utf-8\r\nAllow: GET, HEAD\r\n\r\n" +
                "<html><body><p>HTML Response</p></body></html>";
        assertEquals(status200ResponseWithHTML, response);
    }
}
