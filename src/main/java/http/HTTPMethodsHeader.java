package http;

import java.util.List;

public class HTTPMethodsHeader {
    final static String CRLF = "\r\n";

    public static String simpleGet(List<Methods> methods) {
        return String.format("Allow: %s, %s", methods.get(0), methods.get(1));
    }

    public static String html(List<Methods> methods) {
        return String.format("%s%sAllow: %s, %s", ContentTypes.CONTENT_TYPE_HTML.getType(), CRLF, methods.get(0), methods.get(1));
    }

    public static String json(List<Methods> methods) {
        return String.format("%s%sAllow: %s, %s", ContentTypes.CONTENT_TYPE_JSON.getType(), CRLF, methods.get(0), methods.get(1));
    }

    public static String text(List<Methods> methods) {
        return String.format("%s%sAllow: %s, %s", ContentTypes.CONTENT_TYPE_TEXT.getType(), CRLF, methods.get(0), methods.get(1));
    }

    public static String xml(List<Methods> methods) {
        return String.format("%s%sAllow: %s, %s", ContentTypes.CONTENT_TYPE_XML.getType(), CRLF, methods.get(0), methods.get(1));
    }

    public static String echo(List<Methods> methods) {
        return String.format("Allow: %s", methods.get(0));
    }

    public static String options(List<Methods> methods) {
        return String.format("Allow: %s, %s, %s", methods.get(0), methods.get(1), methods.get(2));
    }

    public static String options2(List<Methods> methods) {
        return String.format("Allow: %s, %s, %s, %s, %s", methods.get(0), methods.get(1), methods.get(2), methods.get(3), methods.get(4));
    }

    public static String redirect(List<Methods> methods) {
        String redirectLocation = "Location: http://127.0.0.1:5000/simple_get";
        return String.format("%s%sAllow: %s, %s", redirectLocation, CRLF, methods.get(0), methods.get(1));
    }

    public static String head(List<Methods> methods) {
        return String.format("Allow: %s, %s", methods.get(0), methods.get(1));
    }
}

