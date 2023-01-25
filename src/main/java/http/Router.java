package http;

import http.routes.*;
import http.routes.structured_data.HTMLResponse;
import http.routes.structured_data.JSONResponse;
import http.routes.structured_data.TextResponse;
import http.routes.structured_data.XMLResponse;

import java.util.HashMap;

public class Router {
    HashMap<String, Route> routeHashMap;
    public Router() {
        routeHashMap = new HashMap<>();
        routeHashMap.put("/simple_get", new SimpleGET());
        routeHashMap.put("/simple_get_with_body", new SimpleGETWithBody());
        routeHashMap.put("/head_request", new SimpleHEAD());
        routeHashMap.put("/redirect", new Redirect());
        routeHashMap.put("/method_options", new MethodOptions());
        routeHashMap.put("/method_options2", new MethodOptions2());
        routeHashMap.put("/echo_body", new EchoBody());
        routeHashMap.put("/text_response", new TextResponse());
        routeHashMap.put("/html_response", new HTMLResponse());
        routeHashMap.put("/json_response", new JSONResponse());
        routeHashMap.put("/xml_response", new XMLResponse());
    }

    public Response getResponse(String method, String path, String body) {
        if (routeHashMap.containsKey(path)) {
            Route route = routeHashMap.get(path);
            return route.response(method, body);
        } else {
            Route notFound = new NotFound();
            return notFound.response(method, body);
        }
    }

}
