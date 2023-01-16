package http;

public class ResponseHandler {

    Router router;
    public ResponseHandler(Router router) {
        this.router = router;
    }

    public Response getResponse(String method, String path, String body) {
        if (this.router.getResponse(method, path, body) != null) {
            return this.router.getResponse(method, path, body);
        }
        return new ResponseBuilder()
                .withStatusCode(HTTPStatusCodes._404.getCode())
                .withHeader("")
                .withBody("")
                .build();
    }

}

