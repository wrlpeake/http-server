package http.routes.structured_data;

import http.*;
import org.json.JSONObject;
import java.util.Arrays;
import java.util.List;


public class JSONResponse implements Route {
    final String CRLF;
    final List<String> headers;
    final String headersResponse;
    final JSONObject jsonBody;

    public JSONResponse() {
        CRLF = "\r\n";
        headers = Arrays.asList(ContentTypes.CONTENT_TYPE_JSON.getType(), Methods.GET.getMethod(), Methods.HEAD.getMethod());
        headersResponse = String.format("%s%sAllow: %s, %s", headers.get(0), CRLF, headers.get(1), headers.get(2));
        jsonBody = new JSONObject("{ key1: 'value1', key2: 'value2' }");
    }

    @Override
    public Response response(String method, String body) {
        if (headers.contains(method)) {
            return new ResponseBuilder()
                    .withStatusCode(HTTPStatusCodes._200.getCode())
                    .withHeader(headersResponse)
                    .withBody(jsonBody.toString())
                    .build();
        }
        return new ResponseBuilder()
                .withStatusCode(HTTPStatusCodes._405.getCode())
                .withHeader(headersResponse)
                .withBody("")
                .build();
    }
}
