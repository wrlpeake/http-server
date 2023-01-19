package http;

public enum Methods {
    GET("GET"),
    HEAD("HEAD"),
    OPTIONS("OPTIONS"),
    POST("POST"),
    PUT("PUT");

    private final String method;

    Methods(String method) { this.method = method; }
    public String getMethod() { return method; }
}
