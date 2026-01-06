package com.portfolio.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PROFILE")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String title;        // Java Full Stack Engineer
    private String experience;   // 3.4+ Years Experience

    @Column(length = 1000)
    private String tagline;

    public Profile(){}

    public Profile(Long id, String fullName, String title, String experience, String tagline) {
        this.id = id;
        this.fullName = fullName;
        this.title = title;
        this.experience = experience;
        this.tagline = tagline;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getExperience() {
        return experience;
    }

    public String getTitle() {
        return title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", title='" + title + '\'' +
                ", experience='" + experience + '\'' +
                ", tagline='" + tagline + '\'' +
                '}';
    }
}
