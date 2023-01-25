package http;

public class Request {
    private final String request;
    private final String parameters;
    private final Methods method;
    private final String path;
    private final String body;

    public Request(String request, String parameters, Methods method, String path, String body) {
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

    public Methods getMethod() {
        return this.method;
    }

    public String getPath() {
        return this.path;
    }

    public String getBody() {
        return this.body;
    }
}
