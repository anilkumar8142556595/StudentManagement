package com.Anil.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Anil.entity.Student;
import com.Anil.repository.StudentRepository;
import com.Anil.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // =====================
    // CREATE
    // =====================
    @Override
    public Student saveStudent(Student student) {

        // Check duplicate email
        Optional<Student> existing = studentRepository.findByEmail(student.getEmail());

        if (existing.isPresent()) {
            throw new RuntimeException(
                "Student with email " + student.getEmail() + " already exists!"
            );
        }

        return studentRepository.save(student);
    }

    // =====================
    // READ ALL
    // =====================
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // =====================
    // READ BY ID
    // =====================
    @Override
    public Student getStudentById(Long id) {

        Optional<Student> optional = studentRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

    // =====================
    // UPDATE
    // =====================
    @Override
    public Student updateStudent(Long id, Student updatedStudent) {

        // Step 1: Find existing student
        Student existingStudent = getStudentById(id);

        // Step 2: Check if new email belongs to another student
        if (!existingStudent.getEmail().equals(updatedStudent.getEmail())) {
            Optional<Student> studentWithSameEmail =
                studentRepository.findByEmail(updatedStudent.getEmail());

            if (studentWithSameEmail.isPresent()) {
                throw new RuntimeException(
                    "Email " + updatedStudent.getEmail() + " is already used!"
                );
            }
        }

        // Step 3: Update fields using setters
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setCourse(updatedStudent.getCourse());
        existingStudent.setFee(updatedStudent.getFee());
        existingStudent.setEmail(updatedStudent.getEmail());

        // Step 4: Save — Hibernate runs UPDATE query (not INSERT)
        return studentRepository.save(existingStudent);
    }

    // =====================
    // DELETE
    // =====================
    @Override
    public String deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with ID: " + id);
        }

        studentRepository.deleteById(id);
        return "Student with ID " + id + " deleted successfully!";
    }

    // =====================
    // GET BY COURSE
    // =====================
    @Override
    public List<Student> getStudentsByCourse(String course) {

        if (course == null || course.trim().isEmpty()) {
            throw new RuntimeException("Course name cannot be empty!");
        }

        return studentRepository.findByCourse(course.trim());
    }

    // =====================
    // EXISTS CHECK
    // =====================
    @Override
    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }

    // =====================
    // COUNT
    // =====================
    @Override
    public long getStudentCount() {
        return studentRepository.count();
    }
}