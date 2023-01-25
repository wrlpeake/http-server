package http.routes.structured_data;

import http.*;

import java.util.Arrays;
import java.util.List;

import static http.Methods.*;

public class HTMLResponse implements Route {


    public List<Methods> allowedMethods() {
        return Arrays.asList(GET, HEAD);
    }

    @Override
    public Response response(Methods method, String body) {
        String textBody = "<html><body><p>HTML Response</p></body></html>";
        String httpMethods = HTTPMethodsHeader.html(allowedMethods());
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
