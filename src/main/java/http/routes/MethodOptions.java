package http.routes;

import http.*;

import java.util.Arrays;
import java.util.List;

import static http.Methods.*;

public class MethodOptions implements Route {

    public List<Methods> allowedMethods() {
        return Arrays.asList(GET, HEAD, OPTIONS);
    }

    @Override
    public Response response(Methods method, String body) {
        String httpMethods = HTTPMethodsHeader.options(allowedMethods());
        if (allowedMethods().contains(method)) {
            return new ResponseBuilder()
                    .withStatusCode(HTTPStatusCodes._200.getCode())
                    .withHeader(httpMethods)
                    .withBody("")
                    .build();
        }
        return new ResponseBuilder()
                .withStatusCode(HTTPStatusCodes._405.getCode())
                .withHeader(httpMethods)
                .withBody("")
                .build();
    }
}
