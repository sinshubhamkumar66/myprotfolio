package com.portfolio.app.repository;

import com.portfolio.app.entity.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummaryRepository
        extends JpaRepository<Summary, Long> {
}
