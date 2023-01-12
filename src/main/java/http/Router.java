package http;

import http.routes.Redirect;
import http.routes.SimpleGET;
import http.routes.SimpleGETWithBody;
import http.routes.SimpleHEAD;

public class Router {

    public static String getResponse(String method, String path) {
        switch (path) {
            case "/simple_get":
                SimpleGET simpleGET = new SimpleGET();
                return simpleGET.response(method);
            case "/simple_get_with_body":
                SimpleGETWithBody simpleGETWithBody = new SimpleGETWithBody();
                return simpleGETWithBody.response(method);
            case "/head_request":
                SimpleHEAD simpleHEAD = new SimpleHEAD();
                return simpleHEAD.response(method);
            case "/redirect":
                Redirect redirect = new Redirect();
                return redirect.response(method);
        }
        return null;
    }
}
