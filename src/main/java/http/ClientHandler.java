package http;

import java.io.*;
import java.net.Socket;

public class ClientHandler {
    private final Socket client;
    private final ResponseHandler responseHandler;

    public ClientHandler(Socket socket) {
        client = socket;
        Router router = new Router();
        responseHandler = new ResponseHandler(router);
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

            Response response = responseHandler.getResponse(method, path, body);
            out.write(response.getResponse().getBytes());
            out.writeTo(client.getOutputStream());

            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

