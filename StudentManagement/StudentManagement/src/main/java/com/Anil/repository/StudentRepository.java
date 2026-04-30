package com.Anil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Anil.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Spring auto-generates SQL: SELECT * FROM student WHERE email = ?
    Optional<Student> findByEmail(String email);

    // Spring auto-generates SQL: SELECT * FROM student WHERE course = ?
    List<Student> findByCourse(String course);
}