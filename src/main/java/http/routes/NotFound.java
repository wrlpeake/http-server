package http.routes;

import http.HTTPStatusCodes;
import http.Response;
import http.ResponseBuilder;
import http.Route;

public class NotFound implements Route {

    @Override
    public Response response(String method, String path) {
        return new ResponseBuilder()
                .withStatusCode(HTTPStatusCodes._404.getCode())
                .withHeader("")
                .withBody("")
                .build();
    }
}
