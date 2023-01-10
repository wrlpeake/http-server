package http;

public class ResponseHandler {

    public ResponseHandler() {
    }

    public String buildResponse(String method, String path) {
        if (Routes.getRoute(method, path)) {
            return "HTTP/1.1 200 OK\r\n\r\n";
        }
        return "HTTP/1.1 404 Not Found\r\n\r\n";
    }

    public byte[] response(String responseString) {
        return responseString.getBytes();
    }
}