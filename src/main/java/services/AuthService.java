package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class AuthService {
    private static final String BASE_URI = "http://localhost:3001/auth";
    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "password123";

    private final String token;
    private final RequestSpecification requestSpec;

    public AuthService(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .build();
        token = requestSpec.param("username", USER_NAME).param("password", PASSWORD).post()
                .then().extract().path("token");
    }

    public String getToken(){
        return token;
    }
}
