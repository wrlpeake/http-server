package http.routes.structured_data;

import http.HTTPStatusCodes;
import http.HTTPMethodsHeader;
import http.Methods;
import http.Response;
import http.ResponseBuilder;
import http.Route;
import org.json.JSONObject;
import java.util.Arrays;
import java.util.List;

import static http.Methods.GET;
import static http.Methods.HEAD;

public class JSONResponse implements Route {

    public List<Methods> allowedMethods() {
        return Arrays.asList(GET, HEAD);
    }

    @Override
    public Response response(Methods method, String body) {
        JSONObject jsonBody = new JSONObject("{ key1: 'value1', key2: 'value2' }");
        String httpMethods = HTTPMethodsHeader.json(allowedMethods());
        if (allowedMethods().contains(method)) {
            return new ResponseBuilder()
                    .withStatusCode(HTTPStatusCodes._200.getCode())
                    .withHeader(httpMethods)
                    .withBody(jsonBody.toString())
                    .build();
        }
        return new ResponseBuilder()
                .withStatusCode(HTTPStatusCodes._405.getCode())
                .withHeader(httpMethods)
                .withBody("")
                .build();
    }
}
