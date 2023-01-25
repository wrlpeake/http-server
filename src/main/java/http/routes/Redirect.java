package http.routes;

import http.HTTPMethodsHeader;
import http.HTTPStatusCodes;
import http.Methods;
import http.Response;
import http.ResponseBuilder;
import http.Route;

import java.util.Arrays;
import java.util.List;

import static http.Methods.GET;
import static http.Methods.HEAD;

public class Redirect implements Route {

    public List<Methods> allowedMethods() {
        return Arrays.asList(GET, HEAD);
    }

    @Override
    public Response response(Methods method, String body) {
        String httpMethods = HTTPMethodsHeader.redirect(allowedMethods());
        if (allowedMethods().contains(method)) {
            return new ResponseBuilder()
                    .withStatusCode(HTTPStatusCodes._301.getCode())
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
