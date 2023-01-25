package http.routes.structured_data;

import http.*;

import java.util.Arrays;
import java.util.List;

import static http.Methods.*;

public class TextResponse implements Route {

    public List<Methods> allowedMethods() {
        return Arrays.asList(GET, HEAD);
    }

    @Override
    public Response response(Methods method, String body) {
        String textBody = "text response";
        String httpMethods = HTTPMethodsHeader.text(allowedMethods());
        if (allowedMethods().contains(method)) {
            return new ResponseBuilder()
                    .withStatusCode(HTTPStatusCodes._200.getCode())
                    .withHeader(httpMethods)
                    .withBody(textBody)
                    .build();
        }
        return new ResponseBuilder()
                .withStatusCode(HTTPStatusCodes._405.getCode())
                .withHeader(httpMethods)
                .withBody("")
                .build();
    }
}
