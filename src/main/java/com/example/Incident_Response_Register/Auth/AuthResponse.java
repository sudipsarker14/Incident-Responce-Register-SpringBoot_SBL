package com.example.Incident_Response_Register.Auth;

import lombok.Getter;

@Getter
public class AuthResponse {
    private final String token;
    private final String role;
    public AuthResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }
}
