package http;

import java.io.IOException;
import java.io.InputStream;

public class RequestHandler {

    public String getRequest(InputStream in) throws IOException {
        int readInputStream;
        StringBuilder request = new StringBuilder();
        while (!((readInputStream = in.read()) == -1 || in.available() == 0)) {
            request.append((char) readInputStream);
        }
        request.append((char) readInputStream);

        return request.toString();
    }

    public String getRequestParameters(String request) {
        return request.split("\r\n")[0];
    }
}
