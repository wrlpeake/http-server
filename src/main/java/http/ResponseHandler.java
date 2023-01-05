package http;

public class ResponseHandler {
    String pageNotFoundResponse;
    public ResponseHandler() {
        pageNotFoundResponse = "HTTP/1.1 404 Not Found\r\n\r\n";
    }

    public byte[] getPageNotFoundResponse() {
        return pageNotFoundResponse.getBytes();
    }
}