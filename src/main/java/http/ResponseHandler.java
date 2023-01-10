package http;

public class ResponseHandler {

    public byte[] getPageNotFoundResponse() {
        String pageNotFoundResponse = "HTTP/1.1 404 Not Found\r\n\r\n";
        return pageNotFoundResponse.getBytes();
    }
}