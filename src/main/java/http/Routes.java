package http;

public class Routes {

    public static boolean getRoute(String method, String path) {
        return method.equals("GET") && path.equals("/simple_get");
    }
}
