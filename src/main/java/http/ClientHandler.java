package http;

import java.io.*;
import java.net.Socket;

public class ClientHandler {
    private final Socket client;
    private final RequestHandler requestHandler;

    private final ResponseHandler responseHandler;

    public ClientHandler(Socket socket) {
        client = socket;
        requestHandler = new RequestHandler();
        responseHandler = new ResponseHandler();
    }

    public void start() {
        try {
            InputStream in = client.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            String request = requestHandler.getRequest(in);
            String parameters = requestHandler.getRequestParameters(request);
            String method = requestHandler.getMethod(parameters);
            String path = requestHandler.getPath(parameters);

            String statusCode = responseHandler.buildResponse(method, path);
            out.write(responseHandler.response(statusCode));
            out.writeTo(client.getOutputStream());

            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
