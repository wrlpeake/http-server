package http;

public interface Route {
    String response(String method, String body);
}
