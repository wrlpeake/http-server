package http;

public interface Route {
    default Response response(Methods method, String body) {
        return new ResponseBuilder()
                .withStatusCode(null)
                .withHeader(null)
                .withBody(null)
                .build();
    }
}
