package com.example.Incident_Response_Register.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
import javax.crypto.SecretKey;

import com.example.Incident_Response_Register.entity.User;

@Component
public class JwtUtil {
    private static final String SECRET = "0vC1KYuTIjFOgyYgBp/qy6+Sq/FY/3Y4VO5c2ydE8g0=";

    public String generateToken(User user) {
        return Jwts.builder()
                .claim("username", user.getUsername())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .compact();
    }

    public String extractUsername(String token) {
        return parseToken(token).get("username", String.class);
    }

    public String extractRole(String token) {
        return parseToken(token).get("role", String.class);
    }

    private Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();
    }
}
