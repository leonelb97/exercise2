package org.example.utils;

import com.google.gson.Gson;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.options.RequestOptions;
import org.example.BaseTest;



public class APIUtils  {
    private final APIRequestContext apiContext;
    private final String registerEndPoint;

    public APIUtils(APIRequestContext apiContext) {
        this.apiContext = apiContext;
        this.registerEndPoint = "api/auth/register";
    }

    public APIResponse get(String endpoint) {
        return apiContext.get(endpoint);
    }

    public APIResponse post(String endpoint, String payload) {
        return apiContext.post(endpoint, RequestOptions.create().setData(payload));
    }

    public APIResponse put(String endpoint, String payload) {
        return apiContext.put(endpoint, RequestOptions.create().setData(payload));
    }

    public APIResponse delete(String endpoint) {
        return apiContext.delete(endpoint);
    }

    public void createUser(SignUpHelper signUpHelper) {
       APIResponse response = apiContext.post(registerEndPoint, RequestOptions.create()
                       .setHeader("Content-Type", "application/json")
                        .setData(new Gson().toJson(signUpHelper)));
        if (response.status() == 201) {
            System.out.println("User created successfully.");
        } else {
            throw new RuntimeException("User creation failed with status: " + response.status() + response.text());
        }

    }
}
