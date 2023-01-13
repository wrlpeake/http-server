package http.routes;

import http.Codes;
import http.Route;

import java.util.Arrays;
import java.util.List;

public class Redirect implements Route {
    final String CRLF;
    final List<String> headers;
    final String headersResponse;

    final String redirectLocation;
    public Redirect() {
        CRLF = "\r\n";
        headers = Arrays.asList("GET", "HEAD");
        headersResponse = String.format("Allow: %s, %s", headers.get(0), headers.get(1));
        redirectLocation = "Location: http://127.0.0.1:5000/simple_get";
    }
    @Override
    public String response(String method, String body) {
        if (headers.contains(method)) {
            return Codes.HTTP_VERSION.getCode() + Codes._301.getCode() + CRLF + redirectLocation + CRLF + headersResponse + CRLF + CRLF;
        }
        return Codes.HTTP_VERSION.getCode() + Codes._405.getCode() + CRLF + headersResponse + CRLF + CRLF;
    }
}
