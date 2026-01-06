package com.portfolio.app.service;

import com.portfolio.app.entity.CompanyProject;
import com.portfolio.app.repository.CompanyProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyProjectService {

    private final CompanyProjectRepository repository;

    public CompanyProjectService(CompanyProjectRepository repository) {
        this.repository = repository;
    }

    public CompanyProject saveProject(CompanyProject project) {
        return repository.save(project);
    }

    public List<CompanyProject> getAllProjects() {
        return repository.findAll();
    }

    public void deleteProject(Long id) {
        repository.deleteById(id);
    }
}

