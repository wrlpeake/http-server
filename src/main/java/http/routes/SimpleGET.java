package http.routes;

import http.*;

import java.util.Arrays;
import java.util.List;

public class SimpleGET implements Route {
    final List<String> headers;
    final String headersResponse;

    public SimpleGET() {
        headers = Arrays.asList(Methods.GET.getMethod(), Methods.HEAD.getMethod());
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
