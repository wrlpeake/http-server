package http.routes;

import http.*;

public class NotFound implements Route {

    @Override
    public Response response(Methods method, String path) {
        return new ResponseBuilder()
                .withStatusCode(HTTPStatusCodes._404.getCode())
                .withHeader("")
                .withBody("")
                .build();
    }
}
