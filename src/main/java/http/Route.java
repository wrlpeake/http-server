package http;

public interface Route {
    Response response(String method, String body);
}
