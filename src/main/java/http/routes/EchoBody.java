package http.routes;

import http.*;

import java.util.List;

public class EchoBody implements Route {
    final String CRLF;
    final List<String> headers;
    final String headersResponse;

    public EchoBody() {
        CRLF = "\r\n";
        headers = List.of(Methods.POST.getMethod());
        headersResponse = String.format("Allow: %s", headers.get(0));
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
