package com.portfolio.app.controller;

import com.portfolio.app.entity.CompanyProject;
import com.portfolio.app.service.CompanyProjectService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class CompanyProjectController {

    private final CompanyProjectService service;

    public CompanyProjectController(CompanyProjectService service) {
        this.service = service;
    }


    // ===== USER =====
    @GetMapping("/projects")
    public ResponseEntity<List<CompanyProject>> getProjects() {
        return ResponseEntity.ok(service.getAllProjects());
    }

    // ===== ADMIN =====
    @PostMapping("/admin/projects")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CompanyProject> addProject(
            @RequestBody CompanyProject project) {
        return ResponseEntity.ok(service.saveProject(project));
    }

    @DeleteMapping("/admin/projects/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        service.deleteProject(id);
        return ResponseEntity.ok().build();
    }
}

