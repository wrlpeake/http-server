package http;

public class Response {
    private final String statusCode;
    private final String header;

    private final String body;

    public Response(String statusCode, String header, String body) {
        this.statusCode = statusCode;
        this.header = header;
        this.body = body;
    }

    public String responseString() {
        return (statusCode + header + body);
    }
}
