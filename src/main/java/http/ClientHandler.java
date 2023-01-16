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

            Request request = new Request(RequestHandler.getRequest(in));
            request.parseRequest();

            Response response = responseHandler.getResponse(request.getMethod(), request.getPath(), request.getBody());
            out.write(response.responseString().getBytes());
            out.writeTo(client.getOutputStream());

            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

