package http;

public class Request {
    private final String request;
    private final String parameters;
    private final String method;
    private final String path;
    private final String body;

    public Request(String request, String parameters, String method, String path, String body) {
        this.request = request;
        this.parameters = parameters;
        this.method = method;
        this.path = path;
        this.body = body;
    }

    public String getRequest() {
        return this.request;
    }

    public String getParameters() {
        return this.parameters;
    }

    public String getMethod() {
        return this.method;
    }

    public String getPath() {
        return this.path;
    }

    public String getBody() {
        return this.body;
    }
}
