package http;

public class ResponseHandler {

    public ResponseHandler() {
    }

    public String buildResponse(String method, String path) {
        if (Router.getResponse(method, path) != null) {
            return Router.getResponse(method, path);
        }
        return "HTTP/1.1 404 Not Found\r\n\r\n";
    }

    public byte[] response(String responseString) {
        return responseString.getBytes();
    }
}