package http;

public class Routes {

    public static boolean getRoute(String method, String path) {
        if (method.equals("GET") && path.equals("/simple_get")) {
            return true;
        } else if (method.equals("HEAD") && path.equals("/simple_get")) {
            return true;
        } else if (method.equals("HEAD") && path.equals("/head_request")) {
            return true;
        }
        return method.equals("GET") && path.equals("/simple_get_with_body");
    }

    public static String getBody(String method, String path) {
        if (method.equals("GET") && path.equals("/simple_get_with_body")) {
            return "Hello world";
        }
        return "";
    }
}
