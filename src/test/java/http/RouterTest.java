package http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RouterTest {
    Router router = new Router();
    String method;
    String path;
    String body;
    String expectedResponse;

    @Test
    public void simpleGetRouteTest() {
        method = "GET";
        path = "/simple_get";
        body = "";

        expectedResponse = "HTTP/1.1 200 OK\r\nAllow: GET, HEAD\r\n\r\n";
        Response response = router.getResponse(method, path, body);
        assertEquals(expectedResponse, response.responseString());
    }

    @Test
    public void routeNotFoundTest() {
        method = "POST";
        path = "/does_not_exist";
        body = "foobar";
        expectedResponse = "HTTP/1.1 404 Not Found\r\n\r\n";
        Response response = router.getResponse(method, path, body);
        assertEquals(expectedResponse, response.responseString());
    }

    @Test
    public void routeExistsButMethodNotAllowed405Test() {
        method = "HEAD";
        path = "/echo_body";
        body = "foobar";

        expectedResponse = "HTTP/1.1 405 Method Not Allowed\r\nAllow: POST\r\n\r\n";
        Response response = router.getResponse(method, path, body);
        assertEquals(expectedResponse, response.responseString());
    }

    @Test
    public void simpleGetBodyRouteTest() {
        method = "GET";
        path = "/simple_get_with_body";
        body = "";

        expectedResponse = "HTTP/1.1 200 OK\r\nAllow: GET, HEAD\r\n\r\nHello world";
        Response response = router.getResponse(method, path, body);
        assertEquals(expectedResponse, response.responseString());
    }

    @Test
    public void headRequestRouteTest() {
        method = "HEAD";
        path = "/head_request";
        body = "";

        expectedResponse = "HTTP/1.1 200 OK\r\nAllow: HEAD, OPTIONS\r\n\r\n";
        Response response = router.getResponse(method, path, body);
        assertEquals(expectedResponse, response.responseString());
    }

    @Test
    public void redirectRouteTest() {
        method = "GET";
        path = "/redirect";
        body = "";

        expectedResponse = "HTTP/1.1 301 Redirect\r\nLocation: http://127.0.0.1:5000/simple_get\r\nAllow: GET, HEAD\r\n\r\n";
        Response response = router.getResponse(method, path, body);
        assertEquals(expectedResponse, response.responseString());
    }

    @Test
    public void methodOptionsRouteTest() {
        method = "OPTIONS";
        path = "/method_options";
        body = "";

        expectedResponse = "HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS\r\n\r\n";
        Response response = router.getResponse(method, path, body);
        assertEquals(expectedResponse, response.responseString());
    }

    @Test
    public void methodOptions2RouteTest() {
        method = "OPTIONS";
        path = "/method_options2";
        body = "";

        expectedResponse = "HTTP/1.1 200 OK\r\nAllow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n";
        Response response = router.getResponse(method, path, body);
        assertEquals(expectedResponse, response.responseString());
    }

    @Test
    public void echoBodyRouteTest() {
        method = "POST";
        path = "/echo_body";
        body = "Once upon a time...";

        expectedResponse = "HTTP/1.1 200 OK\r\nAllow: POST\r\n\r\nOnce upon a time...";
        Response response = router.getResponse(method, path, body);
        assertEquals(expectedResponse, response.responseString());
    }

    @Test
    public void textResponseRouteTest() {
        method = "GET";
        path = "/text_response";
        body = "";

        expectedResponse = "HTTP/1.1 200 OK\r\nContent-Type: text/plain;charset=utf-8\r\nAllow: GET, HEAD\r\n\r\n" +
                "text response";
        Response response = router.getResponse(method, path, body);
        assertEquals(expectedResponse, response.responseString());
    }

    @Test
    public void HTMLResponseRouteTest() {
        method = "GET";
        path = "/html_response";
        body = "";

        expectedResponse = "HTTP/1.1 200 OK\r\nContent-Type: text/html;charset=utf-8\r\nAllow: GET, HEAD\r\n\r\n" +
                "<html><body><p>HTML Response</p></body></html>";
        Response response = router.getResponse(method, path, body);
        assertEquals(expectedResponse, response.responseString());
    }
    @Test
    public void JSONResponseRouteTest() {
        method = "GET";
        path = "/json_response";
        body = "";

        expectedResponse = "HTTP/1.1 200 OK\r\nContent-Type: text/html;charset=utf-8\r\nAllow: GET, HEAD\r\n\r\n" +
                "<html><body><p>HTML Response</p></body></html>";
        Response response = router.getResponse(method, path, body);
        assertEquals(expectedResponse, response.responseString());
    }
}
