package http;

import java.util.List;

public class HTTPMethodsHeader {
    final static String CRLF = "\r\n";

    public static String simpleGet(List<Methods> methods) {
        return String.format("Allow: %s, %s", methods.get(0), methods.get(1));
    }

    public static String html(List<Methods> headers) {
        return String.format("%s%sAllow: %s, %s", ContentTypes.CONTENT_TYPE_HTML.getType(), CRLF, headers.get(0), headers.get(1));
    }

    public static String json(List<Methods> headers) {
        return String.format("%s%sAllow: %s, %s", ContentTypes.CONTENT_TYPE_JSON.getType(), CRLF, headers.get(0), headers.get(1));
    }

    public static String text(List<Methods> headers) {
        return String.format("%s%sAllow: %s, %s", ContentTypes.CONTENT_TYPE_TEXT.getType(), CRLF, headers.get(0), headers.get(1));
    }

    public static String xml(List<Methods> headers) {
        return String.format("%s%sAllow: %s, %s", ContentTypes.CONTENT_TYPE_XML.getType(), CRLF, headers.get(0), headers.get(1));
    }

    public static String echo(List<Methods> headers) {
        return String.format("Allow: %s", headers.get(0));
    }

    public static String options(List<Methods> headers) {
        return String.format("Allow: %s, %s, %s", headers.get(0), headers.get(1), headers.get(2));
    }

    public static String options2(List<Methods> method) {
        return String.format("Allow: %s, %s, %s, %s, %s", method.get(0), method.get(1), method.get(2), method.get(3), method.get(4));
    }

    public static String redirect(List<Methods> method) {
        String redirectLocation = "Location: http://127.0.0.1:5000/simple_get";
        return String.format("%s%sAllow: %s, %s", redirectLocation, CRLF, method.get(0), method.get(1));
    }

    public static String head(List<Methods> method) {
        return String.format("Allow: %s, %s", method.get(0), method.get(1));
    }
}

