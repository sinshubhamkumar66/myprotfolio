package com.portfolio.app.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PROJECT")
public class CompanyProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String projectName;

    @Column(nullable = false)
    private String companyName;

    private String role;

    @Column(length = 2000)
    private String description;

    @Column(length = 10000)
    private String responsibilities;

    private String techStack;

    private String duration; // e.g. "Jan 2023 – Present"

    private boolean currentProject;

    public CompanyProject(){}
    public CompanyProject(Long id, String projectName,
                          String companyName, String role, String
                                  description, String responsibilities, String techStack,
                          String duration, boolean currentProject) {
        this.id = id;
        this.projectName = projectName;
        this.companyName = companyName;
        this.role = role;
        this.description = description;
        this.responsibilities = responsibilities;
        this.techStack = techStack;
        this.duration = duration;
        this.currentProject = currentProject;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setCurrentProject(boolean currentProject) {
        this.currentProject = currentProject;
    }

    public Long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public String getTechStack() {
        return techStack;
    }

    public String getDuration() {
        return duration;
    }

    public boolean isCurrentProject() {
        return currentProject;
    }
}


