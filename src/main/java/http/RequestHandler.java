package http;

import java.io.IOException;
import java.io.InputStream;

public class RequestHandler {

    public String getRequest(InputStream in) throws IOException {
        int readInputStream;
        StringBuilder request = new StringBuilder();
        while ((readInputStream = in.read()) != -1 && in.available() != 0) request.append((char) readInputStream);
        request.append((char) readInputStream);
        return request.toString();
    }

    public String getRequestParameters(String request) {
        return request.split("\r\n")[0];
    }

    public String getMethod(String parameters) {
        return parameters.split(" ")[0];
    }

    public String getPath(String parameters) {
        return parameters.split(" ")[1];
    }
    public String getBody(String request) {
        StringBuilder body = new StringBuilder();
        String[] input;
        if (request.contains("Content-Length")) {
            input = request.split("\r\n\r\n");
            body.append(input[input.length - 1].trim());
        }
        return body.toString();
    }
}
