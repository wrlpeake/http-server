package http;

import http.routes.SimpleGET;
import http.routes.SimpleGETWithBody;
import http.routes.SimpleHEAD;

public class Router {

    public static String getResponse(String method, String path) {
        switch (path) {
            case "/simple_get":
                SimpleGET simpleGET = new SimpleGET(method);
                return simpleGET.response(method);
            case "/simple_get_with_body":
                SimpleGETWithBody simpleGETWithBody = new SimpleGETWithBody(method);
                return simpleGETWithBody.response(method);
            case "/head_request":
                SimpleHEAD simpleHEAD = new SimpleHEAD(method);
                return simpleHEAD.response(method);
        }
        return null;
    }
}
