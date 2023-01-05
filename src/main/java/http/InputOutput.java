package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class InputOutput {

    public BufferedReader getSocketInputStream(Socket socket) throws IOException {
            return new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
    }

    public PrintWriter sendSocketOutputStream(Socket socket) throws IOException {
        return new PrintWriter(socket.getOutputStream(), true);
    }

    public String readClientInputStream(BufferedReader inputStream) throws IOException {
        String message = inputStream.readLine();
        if (message == null) {
            message = "ERROR";
        }
        return message;
    }

    public void writeClientOutputStream(PrintWriter writer, String clientMessage) {
        writer.println(clientMessage);
    }

}
