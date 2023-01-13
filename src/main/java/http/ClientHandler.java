package http;

import java.io.*;
import java.net.Socket;

public class ClientHandler {
    private final Socket client;

    public ClientHandler(Socket socket) {
        client = socket;
    }

    public void start() {
        try {
            InputStream in = client.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            String request = RequestHandler.getRequest(in);
            String parameters = RequestHandler.getRequestParameters(request);
            String method = RequestHandler.getMethod(parameters);
            String path = RequestHandler.getPath(parameters);
            String body = RequestHandler.getBody(request);

            String response = ResponseHandler.buildResponse(method, path, body);
            out.write(ResponseHandler.response(response));
            out.writeTo(client.getOutputStream());

            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

