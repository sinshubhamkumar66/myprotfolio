package com.portfolio.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name =  "SUMMARY")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2000)
    private String point; // One bullet summary line

    public Summary(){}

    public Summary(Long id, String point) {
        this.id = id;
        this.point = point;
    }

    public Long getId() {
        return id;
    }

    public String getPoint() {
        return point;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "id=" + id +
                ", point='" + point + '\'' +
                '}';
    }
}

