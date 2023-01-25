package http;

import java.util.HashMap;

public enum Methods {
    GET("GET"),
    HEAD("HEAD"),
    OPTIONS("OPTIONS"),
    POST("POST"),
    PUT("PUT");

    private final String method;

    Methods(String method) { this.method = method; }
    public String getMethod() { return method; }

    public static HashMap<String, Methods> getMethodsHashMap() {
        HashMap<String, Methods> methodsHashMap = new HashMap<>();
        methodsHashMap.put(GET.getMethod(), GET);
        methodsHashMap.put(HEAD.getMethod(), HEAD);
        methodsHashMap.put(OPTIONS.getMethod(), OPTIONS);
        methodsHashMap.put(POST.getMethod(), POST);
        methodsHashMap.put(PUT.getMethod(), PUT);
        return methodsHashMap;
    }
}
