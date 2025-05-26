package com.example.Incident_Response_Register.controller;

import com.example.Incident_Response_Register.Auth.AuthRequest;
import com.example.Incident_Response_Register.Auth.AuthResponse;
import com.example.Incident_Response_Register.entity.User;
import com.example.Incident_Response_Register.repository.UserRepository;
import com.example.Incident_Response_Register.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());

        if (userOpt.isPresent() && userOpt.get().getPassword().equals(request.getPassword())) {
            User user = userOpt.get();
            String token = jwtUtil.generateToken(user);
            return ResponseEntity.ok(new AuthResponse(token, user.getRole()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}
