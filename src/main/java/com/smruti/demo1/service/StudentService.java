package com.smruti.demo1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.smruti.demo1.model.Student;
import com.smruti.demo1.repository.StudentRepository;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addOrUpdateStudent(Student s) {
        return studentRepository.save(s);
    }

    public Optional<Student> getStudent(int roll) {
        return studentRepository.findById(roll);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(int roll) {
        studentRepository.deleteById(roll);
    }
}
