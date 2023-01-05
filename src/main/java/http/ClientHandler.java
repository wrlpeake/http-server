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
            String requestParameters = requestHandler.getRequestParameters(request);

            out.write(responseHandler.getPageNotFoundResponse());

            out.writeTo(client.getOutputStream());
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
