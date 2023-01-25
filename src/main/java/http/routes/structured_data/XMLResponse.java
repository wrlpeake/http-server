package http.routes.structured_data;

import http.*;

import java.util.Arrays;
import java.util.List;

import static http.Methods.*;

public class XMLResponse implements Route {

    public List<Methods> allowedMethods() {
        return Arrays.asList(GET, HEAD);
    }

    @Override
    public Response response(Methods method, String body) {
        String xmlBody = "<note><body>XML Response</body></note>";
        String httpMethods = HTTPMethodsHeader.xml(allowedMethods());
        if (allowedMethods().contains(method)) {
            return new ResponseBuilder()
                    .withStatusCode(HTTPStatusCodes._200.getCode())
                    .withHeader(httpMethods)
                    .withBody(xmlBody)
                    .build();
        }
        return new ResponseBuilder()
                .withStatusCode(HTTPStatusCodes._405.getCode())
                .withHeader(httpMethods)
                .withBody("")
                .build();
    }
}
