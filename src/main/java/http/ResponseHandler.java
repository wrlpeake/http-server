package http;

public class ResponseHandler {

    public ResponseHandler() {
    }

    public String buildResponse(String method, String path) {
        if (Router.getResponse(method, path) != null) {
            return Router.getResponse(method, path);
        }
        return Codes.HTTP_VERSION.getCode() + Codes._404.getCode() + "\r\n\r\n";
    }

    public byte[] response(String responseString) {
        return responseString.getBytes();
    }
}