package http.routes.structured_data;

import http.ContentTypes;
import http.HTTPStatusCodes;
import http.Methods;
import http.Response;
import http.ResponseBuilder;
import http.Route;
import org.json.JSONObject;
import java.util.Arrays;
import java.util.List;


public class JSONResponse implements Route {
    final static String CRLF = "\r\n";
    final List<String> headers;
    final String headersResponse;
    final JSONObject jsonBody;

    public JSONResponse() {
        headers = Arrays.asList(Methods.GET.getMethod(), Methods.HEAD.getMethod());
        headersResponse = String.format("%s%sAllow: %s, %s", ContentTypes.CONTENT_TYPE_JSON.getType(), CRLF, headers.get(0), headers.get(1));
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
