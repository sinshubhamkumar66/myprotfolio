package com.portfolio.app.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String level; // Beginner / Intermediate / Advanced

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SkillCategory category;

    public Skill() {}

    public Skill(String name, String level, SkillCategory category) {
        this.name = name;
        this.level = level;
        this.category = category;
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public SkillCategory getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setCategory(SkillCategory category) {
        this.category = category;
    }
}
