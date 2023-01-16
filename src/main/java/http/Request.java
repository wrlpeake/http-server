package http;

public class Request {
    private final String request;
    private String parameters;
    private String method;
    private String path;
    private String body;

    public Request(String request) {
        this.request = request;
    }

    public void setParameters(String request) {
        this.parameters = RequestHandler.getRequestParameters(request);
    }

    public void setMethod(String parameters) {
        this.method = RequestHandler.getMethod(parameters);
    }

    public void setPath(String parameters) {
        this.path = RequestHandler.getPath(parameters);

    }

    public void setBody(String request) {
        this.body = RequestHandler.getBody(request);
    }

    public void parseRequest() {
        setParameters(this.request);
        setMethod(this.parameters);
        setPath(this.parameters);
        setBody(this.request);
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
