package services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthService {
    private static final String BASE_URI = "http://localhost:3001/auth";
    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "password123";

    private String token;
    private final RequestSpecification requestSpec;

    public AuthService(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .build();
    }

    public String getToken(){
        return token;
    }

    public void createToken(){
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", USER_NAME);
        requestBody.put("password", PASSWORD);
        token = given(requestSpec).body(requestBody).post()
                .then().extract().path("token");
    }
}
