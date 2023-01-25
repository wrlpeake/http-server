package http.routes;

import http.HTTPMethodsHeader;
import http.HTTPStatusCodes;
import http.Methods;
import http.Response;
import http.ResponseBuilder;
import http.Route;

import java.util.Arrays;
import java.util.List;

import static http.Methods.*;

public class MethodOptions2 implements Route {

    public List<Methods> allowedMethods() {
        return Arrays.asList(GET, HEAD, OPTIONS, PUT, POST);
    }

    @Override
    public Response response(Methods method, String body) {
        String httpMethods = HTTPMethodsHeader.options2(allowedMethods());
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
