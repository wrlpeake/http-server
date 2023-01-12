package http.routes;

import http.Codes;

import java.util.Arrays;
import java.util.List;

public class SimpleGET {
    final String CRLF;
    final List<String> headers;
    final String headersResponse;
    final String body;

    public SimpleGET() {
        CRLF = "\r\n";
        headers = Arrays.asList("GET", "HEAD");
        headersResponse = "Allow: GET, HEAD";
        body = "";
    }

    public String response(String method) {
        if (headers.contains(method)) {
            return Codes.HTTP_VERSION.getCode() + Codes._200.getCode() + CRLF + headersResponse + CRLF + CRLF + body;
        }
        return Codes.HTTP_VERSION.getCode() + Codes._405.getCode() + CRLF + headersResponse + CRLF + CRLF;
    }

}
