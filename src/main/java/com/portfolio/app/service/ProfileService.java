package com.portfolio.app.service;

import com.portfolio.app.entity.Profile;
import com.portfolio.app.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository repo;

    public ProfileService(ProfileRepository repo) {
        this.repo = repo;
    }

    public Profile save(Profile profile) {
        return repo.save(profile);
    }

    public Profile getProfile() {
        return repo.findAll().stream().findFirst().orElse(null);
    }
    public void deleteProfile(long id){
         repo.deleteById(id);
    }
}

