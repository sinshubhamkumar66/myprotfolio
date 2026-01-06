package com.portfolio.app.repository;

import com.portfolio.app.entity.CompanyProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyProjectRepository extends JpaRepository<CompanyProject, Long> {
}
