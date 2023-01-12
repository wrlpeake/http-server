package http.routes;

import http.Codes;

import java.util.Arrays;
import java.util.List;

public class MethodOptions {
    final String CRLF;
    final List<String> headers;
    final String headersResponse;

    public MethodOptions() {
        CRLF = "\r\n";
        headers = Arrays.asList("GET", "HEAD", "OPTIONS");
        headersResponse = String.format("Allow: %s, %s, %s", headers.get(0), headers.get(1), headers.get(2));
    }

    public String response(String method) {
        if (headers.contains(method)) {
            return Codes.HTTP_VERSION.getCode() + Codes._200.getCode() + CRLF + headersResponse + CRLF + CRLF;
        }
        return Codes.HTTP_VERSION.getCode() + Codes._405.getCode() + CRLF + headersResponse + CRLF + CRLF;
    }
}
