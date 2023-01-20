package http.routes.structured_data;

import http.*;

import java.util.Arrays;
import java.util.List;

public class XMLResponse implements Route {
    final static String CRLF = "\r\n";
    final List<String> headers;
    final String headersResponse;
    final String xmlBody;

    public XMLResponse() {
        headers = Arrays.asList(ContentTypes.CONTENT_TYPE_XML.getType(), Methods.GET.getMethod(), Methods.HEAD.getMethod());
        headersResponse = String.format("%s%sAllow: %s, %s", headers.get(0), CRLF, headers.get(1), headers.get(2));
        xmlBody = "<note><body>XML Response</body></note>";
    }
    @Override
    public Response response(String method, String body) {
        if (headers.contains(method)) {
            return new ResponseBuilder()
                    .withStatusCode(HTTPStatusCodes._200.getCode())
                    .withHeader(headersResponse)
                    .withBody(xmlBody)
                    .build();
        }
        return new ResponseBuilder()
                .withStatusCode(HTTPStatusCodes._405.getCode())
                .withHeader(headersResponse)
                .withBody("")
                .build();
    }
}
