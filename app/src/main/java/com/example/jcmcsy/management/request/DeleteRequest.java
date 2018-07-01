package com.example.jcmcsy.management.request;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DeleteRequest extends StringRequest {

    final static private String URL = "http://192.168.1.4:8080/user/ajax/userDelete";
    private Map<String, String> parameters;

    public DeleteRequest(String userId, Response.Listener<String> listener) {
        super(Request.Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userId", userId);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
