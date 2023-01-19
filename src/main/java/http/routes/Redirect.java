package http.routes;

import http.*;

import java.util.Arrays;
import java.util.List;

public class Redirect implements Route {
    final String CRLF;
    final List<String> headers;
    final String headersResponse;
    final String redirectLocation;
    public Redirect() {
        CRLF = "\r\n";
        redirectLocation = "Location: http://127.0.0.1:5000/simple_get";
        headers = Arrays.asList(Methods.GET.getMethod(), Methods.HEAD.getMethod());
        headersResponse = String.format("%s%sAllow: %s, %s", redirectLocation, CRLF, headers.get(0), headers.get(1));
    }
    @Override
    public Response response(String method, String body) {
        if (headers.contains(method)) {
            return new ResponseBuilder()
                    .withStatusCode(HTTPStatusCodes._301.getCode())
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
