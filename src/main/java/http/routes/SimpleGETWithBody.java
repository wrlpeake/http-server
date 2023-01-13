package http.routes;

import http.Codes;
import http.Route;

import java.util.Arrays;
import java.util.List;

public class SimpleGETWithBody implements Route {
    final String CRLF;
    final List<String> headers;
    final String headersResponse;

    final String body;

    public SimpleGETWithBody() {
        CRLF = "\r\n";
        headers = Arrays.asList("GET", "HEAD");
        headersResponse = String.format("Allow: %s, %s", headers.get(0), headers.get(1));
        body = "Hello world";
    }

    @Override
    public String response(String method, String requestBody) {
        if (headers.contains(method)) {
            return Codes.HTTP_VERSION.getCode() + Codes._200.getCode() + CRLF + headersResponse + CRLF + CRLF + body;
        }
        return Codes.HTTP_VERSION.getCode() + Codes._405.getCode() + CRLF + headersResponse + CRLF + CRLF;
    }

}
