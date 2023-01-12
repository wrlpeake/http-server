package http.routes;

import java.util.Arrays;
import java.util.List;

public class SimpleGET {
    final String CRLF;
    final String HTTP_VERSION;
    final String statusCode;
    final List<String> headers;
    final String headersResponse;
    final String body;

    final String requestMethod;

    public SimpleGET(String method) {
        CRLF = "\r\n";
        HTTP_VERSION = "HTTP/1.1 ";
        statusCode = "200 OK";
        headers = Arrays.asList("GET", "HEAD");
        headersResponse = "Allow: GET, HEAD";
        body = "";
        requestMethod = method;
    }

    public String response(String method) {
        if (headers.contains(method)) {
            return HTTP_VERSION + statusCode + CRLF + headersResponse + CRLF + CRLF + body;
        }
        return "HTTP/1.1 404 Not Found\r\n\r\n";
    }

}
