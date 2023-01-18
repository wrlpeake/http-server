package http;

import java.io.IOException;
import java.io.InputStream;

public class RequestParser {

    String request;
    String parameters;
    String method;
    String path;
    String body;

    public RequestParser withRequest(InputStream in) throws IOException {
        int readInputStream;
        StringBuilder request = new StringBuilder();
        while ((readInputStream = in.read()) != -1 && in.available() != 0) request.append((char) readInputStream);
        request.append((char) readInputStream);
        this.request = request.toString();
        return this;
    }

    public String buildRequest() {
        return request;
    }

    public RequestParser withParameters() {
        this.parameters = this.request.split("\r\n")[0];
        return this;
    }

    public String buildParameters() {
        return parameters;
    }

    public RequestParser withMethod() {
        this.method = this.parameters.split(" ")[0];
        return this;
    }

    public String buildMethod() {
        return method;
    }

    public RequestParser withPath() {
        this.path = this.parameters.split(" ")[1];
        return this;
    }

    public String buildPath() {
        return path;
    }

    public RequestParser withBody() {
        StringBuilder body = new StringBuilder();
        String[] input;
        if (this.request.contains("Content-Length")) {
            input = this.request.split("\r\n\r\n");
            body.append(input[input.length - 1].trim());
        }
        this.body = body.toString();
        return this;
    }

    public String buildBody() {
        return body;
    }

    public Request parse() {
        return new Request(buildRequest(), buildParameters(), buildMethod(), buildPath(), buildBody());
    }
}
