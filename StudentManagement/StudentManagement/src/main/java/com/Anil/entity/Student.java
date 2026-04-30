package com.Anil.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name", nullable = false)
    private String name;

    @Column(name = "course", nullable = false)
    private String course;

    @Column(name = "fee")
    private Double fee;

    @Column(name = "email", unique = true)
    private String email;

    // =====================
    // NO-ARG CONSTRUCTOR
    // Required by JPA/Hibernate
    // =====================
    public Student() {
    }

    // =====================
    // ALL-ARG CONSTRUCTOR
    // =====================
    public Student(Long id, String name, String course, Double fee, String email) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.fee = fee;
        this.email = email;
    }

    // =====================
    // GETTERS
    // =====================
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public Double getFee() {
        return fee;
    }

    public String getEmail() {
        return email;
    }

    // =====================
    // SETTERS
    // =====================
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // =====================
    // toString
    // =====================
    @Override
    public String toString() {
        return "Student{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", course='" + course + '\''
            + ", fee=" + fee
            + ", email='" + email + '\''
            + '}';
    }
}