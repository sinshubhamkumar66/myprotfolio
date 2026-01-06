package com.portfolio.app.controller;
import com.portfolio.app.entity.Skill;
import com.portfolio.app.service.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class SkillController {

    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    // ===== USER =====
    @GetMapping("/skills")
    public List<Skill> getSkills() {
        return service.getAllSkills();
    }

    // ===== ADMIN =====
    @PostMapping("/admin/skills")
    public Skill addSkill(@RequestBody Skill skill) {
        return service.saveSkill(skill);
    }

    @DeleteMapping("/admin/skills/{id}")
    public void deleteSkill(@PathVariable Long id) {
        service.deleteSkill(id);
    }
}
