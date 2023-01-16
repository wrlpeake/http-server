package http;

public class ResponseHandler {

    Router router;
    public ResponseHandler(Router router) {
        this.router = router;
    }

    public String buildResponse(String method, String path, String body) {
        if (this.router.getResponse(method, path, body) != null) {
            return this.router.getResponse(method, path, body);
        }
        return Codes.HTTP_VERSION.getCode() + Codes._404.getCode() + "\r\n\r\n";
    }

    public byte[] response(String responseString) {
        return responseString.getBytes();
    }
}
