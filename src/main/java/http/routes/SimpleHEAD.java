package http.routes;

import http.*;

import java.util.Arrays;
import java.util.List;

import static http.Methods.*;

public class SimpleHEAD implements Route {

    public List<Methods> allowedMethods() {
        return Arrays.asList(HEAD, OPTIONS);
    }

    @Override
    public Response response(Methods method, String body) {
        String httpMethods = HTTPMethodsHeader.head(allowedMethods());
        if (allowedMethods().contains(method)) {
            return new ResponseBuilder()
                    .withStatusCode(HTTPStatusCodes._200.getCode())
                    .withHeader(httpMethods)
                    .withBody(body)
                    .build();
        }
        return new ResponseBuilder()
                .withStatusCode(HTTPStatusCodes._405.getCode())
                .withHeader(httpMethods)
                .withBody("")
                .build();
    }
}
