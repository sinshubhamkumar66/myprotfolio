package com.portfolio.app.service;

import com.portfolio.app.entity.Summary;
import com.portfolio.app.repository.SummaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryService {

    private final SummaryRepository repo;

    public SummaryService(SummaryRepository repo) {
        this.repo = repo;
    }

    public Summary save(Summary summary) {
        return repo.save(summary);
    }

    public List<Summary> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
