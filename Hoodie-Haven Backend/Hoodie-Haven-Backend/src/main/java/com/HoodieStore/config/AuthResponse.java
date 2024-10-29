package com.HoodieStore.config;

public class AuthResponse {
    private String token;

    // Constructor
    public AuthResponse(String token) {
        this.token = token;
    }

    // Getter for the token
    public String getToken() {
        return token;
    }

    // Setter for the token (optional)
    public void setToken(String token) {
        this.token = token;
    }
}
