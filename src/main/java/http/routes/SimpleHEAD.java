package http.routes;

import http.Codes;

import java.util.Arrays;
import java.util.List;

public class SimpleHEAD {
    final String CRLF;
    final List<String> headers;
    final String headersResponse;

    public SimpleHEAD() {
        CRLF = "\r\n";
        headers = Arrays.asList("HEAD", "OPTIONS");
        headersResponse = "Allow: HEAD, OPTIONS";
    }

    public String response(String method) {
        if (headers.contains(method)) {
            return Codes.HTTP_VERSION.getCode() + Codes._200.getCode() + CRLF + headersResponse + CRLF + CRLF;
        }
        return Codes.HTTP_VERSION.getCode() + Codes._405.getCode() + CRLF + headersResponse + CRLF + CRLF;
    }
}
