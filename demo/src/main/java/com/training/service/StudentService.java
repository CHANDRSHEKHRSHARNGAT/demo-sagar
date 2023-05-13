package com.training.service;

import com.training.entity.Student;

import java.util.List;

public interface StudentService {
   // void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException;

    void addStudent(Student student);
    Student getStudentById(int id);
    Student deleteStudentById(int id);
    List<Student> getAllStudents();

    void updateStudent(Student updatedStudent);
}
