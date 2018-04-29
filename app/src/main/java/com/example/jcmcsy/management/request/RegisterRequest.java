package com.example.jcmcsy.management.request;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://192.168.1.4:8080/user/ajax/userCreate";
    private Map<String, String> parameters;

    public RegisterRequest(String userId, String userPassword, String userName, int userAge, String userEmail, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userId", userId);
        parameters.put("userPw", userPassword);
        parameters.put("userNm", userName);
        parameters.put("userEmail", userEmail);
        // parameters.put("userAge", userAge + "");
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;
    }
}
