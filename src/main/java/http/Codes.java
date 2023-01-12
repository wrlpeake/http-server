package http;

public enum Codes {
    HTTP_VERSION("HTTP/1.1 "),
    _200("200 OK"),
    _301("301 Redirect"),
    _404("404 Not Found"),
    _405("405 Method Not Allowed");
    private final String code;

    Codes(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
