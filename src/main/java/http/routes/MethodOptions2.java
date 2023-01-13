package http.routes;

import http.Codes;
import http.Route;

import java.util.Arrays;
import java.util.List;

public class MethodOptions2 implements Route {
    final String CRLF;
    final List<String> headers;
    final String headersResponse;

    public MethodOptions2() {
        CRLF = "\r\n";
        headers = Arrays.asList("GET", "HEAD", "OPTIONS", "PUT", "POST");
        headersResponse = String.format("Allow: %s, %s, %s, %s, %s", headers.get(0), headers.get(1), headers.get(2), headers.get(3), headers.get(4));
    }
    @Override
    public String response(String method, String body) {
        if (headers.contains(method)) {
            return Codes.HTTP_VERSION.getCode() + Codes._200.getCode() + CRLF + headersResponse + CRLF + CRLF;
        }
        return Codes.HTTP_VERSION.getCode() + Codes._405.getCode() + CRLF + headersResponse + CRLF + CRLF;
    }
}
