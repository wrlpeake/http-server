package http.routes.structured_data;

import http.*;

import java.util.Arrays;
import java.util.List;

public class TextResponse implements Route {
    final String CRLF;
    final List<String> headers;
    final String headersResponse;
    final String textBody;

    public TextResponse() {
        CRLF = "\r\n";
        headers = Arrays.asList(ContentTypes.CONTENT_TYPE_TEXT.getType(), Methods.GET.getMethod(), Methods.HEAD.getMethod());
        headersResponse = String.format("%s%sAllow: %s, %s", headers.get(0), CRLF, headers.get(1), headers.get(2));
        textBody = "text response";
    }
    @Override
    public Response response(String method, String body) {
        if (headers.contains(method)) {
            return new ResponseBuilder()
                    .withStatusCode(HTTPStatusCodes._200.getCode())
                    .withHeader(headersResponse)
                    .withBody(textBody)
                    .build();
        }
        return new ResponseBuilder()
                .withStatusCode(HTTPStatusCodes._405.getCode())
                .withHeader(headersResponse)
                .withBody("")
                .build();
    }
}
