package http;

public class ResponseHandler {

    public static String buildResponse(String method, String path, String body) {
        if (Router.getResponse(method, path, body) != null) {
            return Router.getResponse(method, path, body);
        }
        return Codes.HTTP_VERSION.getCode() + Codes._404.getCode() + "\r\n\r\n";
    }

    public static byte[] response(String responseString) {
        return responseString.getBytes();
    }
}