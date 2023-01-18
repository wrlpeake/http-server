package http;

public enum ContentTypes {
    CONTENT_TYPE("Content-Type: "),
    CONTENT_TYPE_TEXT(CONTENT_TYPE.getType() + "text/plain;charset=utf-8"),
    CONTENT_TYPE_HTML(CONTENT_TYPE.getType() + "text/html;charset=utf-8");

    private final String type;

    ContentTypes(String type) { this.type = type; }
    public String getType() { return type; }
}
