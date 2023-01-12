package http;

import http.routes.*;

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
            case "/method_options":
                MethodOptions methodOptions = new MethodOptions();
                return methodOptions.response(method);
        }
        return null;
    }
}
