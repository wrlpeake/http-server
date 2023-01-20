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
    final static String CRLF = "\r\n";
    final List<String> headers;
    final String headersResponse;
    final String textBody;

    public HTMLResponse() {
        headers = Arrays.asList(Methods.GET.getMethod(), Methods.HEAD.getMethod());
        headersResponse = String.format("%s%sAllow: %s, %s", ContentTypes.CONTENT_TYPE_HTML.getType(), CRLF, headers.get(0), headers.get(1));
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
