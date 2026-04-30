package com.Anil.Service;

import java.util.List;

import com.Anil.entity.Student;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Long id, Student updatedStudent);

    String deleteStudent(Long id);

    List<Student> getStudentsByCourse(String course);

    boolean existsById(Long id);

    long getStudentCount();
}