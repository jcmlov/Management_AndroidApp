package com.example.jcmcsy.management.request;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    final static private String URL = "http://192.168.1.4:8080/login/ajax/loginAction";
    private Map<String, String> parameters;

    public LoginRequest(String userId, String userPassword, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userId", userId);
        parameters.put("userPw", userPassword);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;
    }
}
