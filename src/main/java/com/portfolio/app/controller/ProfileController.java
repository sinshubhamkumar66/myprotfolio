package com.portfolio.app.controller;

import com.portfolio.app.entity.Profile;
import com.portfolio.app.service.ProfileService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    // 🔓 Public (Home Page)
    @GetMapping("/profile")
    public Profile getProfile() {
        return service.getProfile();
    }

    // 🔐 Admin
    @PostMapping("/admin/profile")
    public Profile saveProfile(@RequestBody Profile profile) {
        return service.save(profile);
    }

    @DeleteMapping("/admin/profile/{id}")
    public void deleteprofile(@PathVariable Long id ){
        service.deleteProfile(id);
    }
}

