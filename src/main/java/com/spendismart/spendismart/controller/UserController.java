package com.spendismart.spendismart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spendismart.spendismart.dto.LoginRequest;
import com.spendismart.spendismart.entity.User;
import com.spendismart.spendismart.repository.UserRepository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        User existingUser = userRepository.findByUsername(loginRequest.getUsername());
        if (existingUser == null) {
            return ResponseEntity.badRequest().body("User not found");
        }
        if (loginRequest.getPassword().equals(existingUser.getPassword())==false) {
            return ResponseEntity.badRequest().body("Invalid password");
        }
        String token = createJwtToken(loginRequest.getUsername());
        response.addCookie(new Cookie("token", token));
        return ResponseEntity.ok("Login successful");
    }
        
    private String createJwtToken(String username) {
        return username;
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        // Encrypt password 
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        response.addCookie(new Cookie("token", ""));
        return ResponseEntity.ok("Logout successful");
    }

    @GetMapping("/profile")
    public ResponseEntity<String> getProfile(@CookieValue(name = "token") String token) {
        if(token == null || token.isEmpty()) {
            return ResponseEntity.ok("Invalid token");
        }

        return ResponseEntity.ok("Username : " + token);
    }

    @GetMapping("/test")
    public String Test() {
        return new String("Test Page");
    }
    
}
