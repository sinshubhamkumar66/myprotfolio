package com.portfolio.app.service;

import com.portfolio.app.entity.Role;
import com.portfolio.app.entity.User;
import com.portfolio.app.repository.UserRepository;
import com.portfolio.app.util.JwtUtility;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtility jwtUtil;

    public AuthService(UserRepository repo, PasswordEncoder encoder, JwtUtility jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public void signup(String username, String password, Role role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setRole(role);
        repo.save(user);
    }

    public String login(String username, String role) {
        return jwtUtil.generateToken(username, role);
    }
}
