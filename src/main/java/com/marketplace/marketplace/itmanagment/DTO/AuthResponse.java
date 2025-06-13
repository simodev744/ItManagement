package com.marketplace.marketplace.itmanagment.DTO;


public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public AuthResponse() {
    }

    public void setToken(String token) {
        this.token = token;
    }
}
