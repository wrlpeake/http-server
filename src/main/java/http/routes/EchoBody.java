package http.routes;

import http.Codes;
import http.Route;

import java.util.List;

public class EchoBody implements Route {
    final String CRLF;
    final List<String> headers;
    final String headersResponse;

    public EchoBody() {
        CRLF = "\r\n";
        headers = List.of("POST");
        headersResponse = String.format("Allow: %s", headers.get(0));
    }

    @Override
    public String response(String method, String body) {
        if (headers.contains(method)) {
            return Codes.HTTP_VERSION.getCode() + Codes._200.getCode() + CRLF + headersResponse + CRLF + CRLF + body;
        }
        return Codes.HTTP_VERSION.getCode() + Codes._405.getCode() + CRLF + headersResponse + CRLF + CRLF;
    }
}
