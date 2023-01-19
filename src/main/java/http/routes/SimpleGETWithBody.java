package http.routes;

import http.*;

import java.util.Arrays;
import java.util.List;

public class SimpleGETWithBody implements Route {
    final List<String> headers;
    final String headersResponse;
    final String responseBody;

    public SimpleGETWithBody() {
        headers = Arrays.asList(Methods.GET.getMethod(), Methods.HEAD.getMethod());
        headersResponse = String.format("Allow: %s, %s", headers.get(0), headers.get(1));
        responseBody = "Hello world";
    }

    @Override
    public Response response(String method, String body) {
        if (headers.contains(method)) {
            return new ResponseBuilder()
                    .withStatusCode(HTTPStatusCodes._200.getCode())
                    .withHeader(headersResponse)
                    .withBody(responseBody)
                    .build();
        }
        return new ResponseBuilder()
                .withStatusCode(HTTPStatusCodes._405.getCode())
                .withHeader(headersResponse)
                .withBody("")
                .build();
    }

}
