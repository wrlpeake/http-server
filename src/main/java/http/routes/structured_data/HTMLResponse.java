package http.routes.structured_data;

import http.ContentTypes;
import http.HTTPStatusCodes;
import http.Methods;
import http.Response;
import http.ResponseBuilder;
import http.Route;

import java.util.Arrays;
import java.util.List;

public class HTMLResponse implements Route {
    final String CRLF;
    final List<String> headers;
    final String headersResponse;
    final String textBody;

    public HTMLResponse() {
        CRLF = "\r\n";
        headers = Arrays.asList(ContentTypes.CONTENT_TYPE_HTML.getType(), Methods.GET.getMethod(), Methods.HEAD.getMethod());
        headersResponse = String.format("%s%sAllow: %s, %s", headers.get(0), CRLF, headers.get(1), headers.get(2));
        textBody = "<html><body><p>HTML Response</p></body></html>";
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
