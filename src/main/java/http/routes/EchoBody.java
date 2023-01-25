package http.routes;

import http.HTTPMethodsHeader;
import http.HTTPStatusCodes;
import http.Methods;
import http.Response;
import http.ResponseBuilder;
import http.Route;

import java.util.List;

import static http.Methods.POST;

public class EchoBody implements Route {

    public List<Methods> allowedMethods() {
        return List.of(POST);
    }

    @Override
    public Response response(Methods method, String body) {
        String httpMethods = HTTPMethodsHeader.echo(allowedMethods());
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
