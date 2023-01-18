package http.routes;

import http.HTTPStatusCodes;
import http.Response;
import http.ResponseBuilder;
import http.Route;

import java.util.Arrays;
import java.util.List;

public class SimpleGET implements Route {
    final String CRLF;
    final List<String> headers;
    final String headersResponse;

    public SimpleGET() {
        CRLF = "\r\n";
        headers = Arrays.asList("GET", "HEAD");
        headersResponse = String.format("Allow: %s, %s", headers.get(0), headers.get(1));
    }
    @Override
    public Response response(String method, String body) {
        if (headers.contains(method)) {
            return new ResponseBuilder()
                    .withStatusCode(HTTPStatusCodes._200.getCode())
                    .withHeader(headersResponse)
                    .withBody("")
                    .build();
        }
        return new ResponseBuilder()
                .withStatusCode(HTTPStatusCodes._405.getCode())
                .withHeader(headersResponse)
                .withBody("")
                .build();
    }
}
