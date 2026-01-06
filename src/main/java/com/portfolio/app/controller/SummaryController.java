package com.portfolio.app.controller;

import com.portfolio.app.entity.Summary;
import com.portfolio.app.service.SummaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class SummaryController {

    private final SummaryService service;

    public SummaryController(SummaryService service) {
        this.service = service;
    }

    // 🔓 Public (Home Page)
    @GetMapping("/summary")
    public List<Summary> getSummary() {
        return service.getAll();
    }

    // 🔐 Admin
    @PostMapping("/admin/summary")
    public Summary addSummary(@RequestBody Summary summary) {
        return service.save(summary);
    }

    @DeleteMapping("/admin/summary/{id}")
    public void deleteSummary(@PathVariable Long id) {
        service.delete(id);
    }
}

