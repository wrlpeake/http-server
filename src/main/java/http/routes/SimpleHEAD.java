package http.routes;

import http.*;

import java.util.Arrays;
import java.util.List;

public class SimpleHEAD implements Route {
    final List<String> headers;
    final String headersResponse;

    public SimpleHEAD() {
        headers = Arrays.asList(Methods.HEAD.getMethod(), Methods.OPTIONS.getMethod());
        headersResponse = String.format("Allow: %s, %s", headers.get(0), headers.get(1));
    }
    @Override
    public Response response(String method, String body) {
        if (headers.contains(method)) {
            return new ResponseBuilder()
                    .withStatusCode(HTTPStatusCodes._200.getCode())
                    .withHeader(headersResponse)
                    .withBody(body)
                    .build();
        }
        return new ResponseBuilder()
                .withStatusCode(HTTPStatusCodes._405.getCode())
                .withHeader(headersResponse)
                .withBody("")
                .build();
    }
}
