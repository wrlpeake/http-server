package http;

import java.util.Objects;

public class ResponseBuilder {

    final String CRLF = "\r\n";
    String statusCode;
    String header;
    String body;

    public ResponseBuilder withStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String buildStatusLine() {
        return HTTPStatusCodes.HTTP_VERSION.getCode() + statusCode + CRLF;
    }

    public ResponseBuilder withHeader(String headerResponse) {
        this.header = headerResponse;
        return this;
    }


    public String buildHeader() {
        if (Objects.equals(header, "")) {
            return header + CRLF;
        }
        return header + CRLF + CRLF;
    }

    public ResponseBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public String buildBody() {
        return body;
    }

    public Response build() {
        return new Response(buildStatusLine(), buildHeader(), buildBody());
    }
}
