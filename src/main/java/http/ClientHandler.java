package http;

import java.io.*;
import java.net.Socket;

public class ClientHandler {
    private final Socket client;
    private final Router router;

    public ClientHandler(Socket socket) {
        client = socket;
        router = new Router();
    }

    public void start() {
        try {
            InputStream in = client.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            Request request = new RequestParser()
                    .withRequest(in)
                    .withParameters()
                    .withMethod()
                    .withPath()
                    .withBody()
                    .parse();

            Response response = router.getResponse(request.getMethod(), request.getPath(), request.getBody());
            out.write(response.responseString().getBytes());
            out.writeTo(client.getOutputStream());

            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

