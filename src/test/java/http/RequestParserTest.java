package http;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestParserTest {

    @Test
    public void getRequestTest() throws IOException {
        String requestTest = "OPTIONS /method_options2 HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestTest.getBytes());

        Request request = new RequestParser()
                            .withRequest(input)
                            .withParameters()
                            .withMethod()
                            .withPath()
                            .withBody()
                            .parse();

        assertEquals(requestTest, request.getRequest());
    }
    @Test
    public void getRequestParametersTest() throws IOException {
        String requestTest = "POST /echo_body HTTP/1.1\r\nContent-Type: text/plain\r\nContent-Length: 7\r\n\r\nSunrise";
        ByteArrayInputStream input = new ByteArrayInputStream(requestTest.getBytes());

        Request request = new RequestParser()
                            .withRequest(input)
                            .withParameters()
                            .withMethod()
                            .withPath()
                            .withBody()
                            .parse();

        String parameters = "POST /echo_body HTTP/1.1";
        assertEquals(parameters, request.getParameters());
    }

    @Test
    public void getMethodTest() throws IOException {
        String requestTest = "GET /foo_bar HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestTest.getBytes());

        Request request = new RequestParser()
                .withRequest(input)
                .withParameters()
                .withMethod()
                .withPath()
                .withBody()
                .parse();

        String method = "GET";
        assertEquals(method, request.getMethod());
    }

    @Test
    public void getPathTest() throws IOException {
        String requestTest = "HEAD /under_the_sea HTTP/1.1\r\n";
        ByteArrayInputStream input = new ByteArrayInputStream(requestTest.getBytes());

        Request request = new RequestParser()
                .withRequest(input)
                .withParameters()
                .withMethod()
                .withPath()
                .withBody()
                .parse();

        String path = "/under_the_sea";
        assertEquals(path, request.getPath());
    }

    @Test
    public void getBodyTest() throws IOException {
        String requestTest = "POST /to_the_moon HTTP/1.1\r\nContent-Type: text/plain\r\nContent-Length: 11\r\n\r\nHello world";
        ByteArrayInputStream input = new ByteArrayInputStream(requestTest.getBytes());

        Request request = new RequestParser()
                .withRequest(input)
                .withParameters()
                .withMethod()
                .withPath()
                .withBody()
                .parse();

        String expectedBody = "Hello world";
        assertEquals(expectedBody, request.getBody());
    }
}
