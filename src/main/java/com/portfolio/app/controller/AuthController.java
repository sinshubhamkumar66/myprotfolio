package com.portfolio.app.controller;

import com.portfolio.app.entity.User;
import com.portfolio.app.repository.UserRepository;
import com.portfolio.app.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationManager authManager;
    private final AuthService authService;
    private final UserRepository repo;

    public AuthController(AuthenticationManager authManager,
                          AuthService authService,
                          UserRepository repo) {
        this.authManager = authManager;
        this.authService = authService;
        this.repo = repo;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        authService.signup(user.getUsername(), user.getPassword(), user.getRole());
        return ResponseEntity.ok("Signup successful");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(), user.getPassword()));

        User dbUser = repo.findByUsername(user.getUsername()).get();
        String token = authService.login(dbUser.getUsername(), dbUser.getRole().name());

        return ResponseEntity.ok(Map.of(
                "token", token,
                "role", dbUser.getRole().name()
        ));
    }
}

