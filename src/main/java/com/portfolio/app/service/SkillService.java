package com.portfolio.app.service;

import com.portfolio.app.entity.Skill;
import com.portfolio.app.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository repository;

    public SkillService(SkillRepository repository) {
        this.repository = repository;
    }

    public List<Skill> getAllSkills() {
        return repository.findAll();
    }

    public Skill saveSkill(Skill skill) {
        return repository.save(skill);
    }

    public void deleteSkill(Long id) {
        repository.deleteById(id);
    }
}

