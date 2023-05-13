package com.training.ServiceImpl;
import com.training.entity.Student;
import com.training.service.StudentService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private static List<Student> students = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void addStudent(Student student) {
        student.setId(nextId++);
        students.add(student);
    }
    @Override
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    //delete student by id
    public Student deleteStudentById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return students.remove(i);
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public void updateStudent(Student updatedStudent) {
        for (Student student : students) {
            if (student.getId() == updatedStudent.getId()) {
                student.setName(updatedStudent.getName());
                student.setGender(updatedStudent.getGender());//
                student.setCourse(updatedStudent.getCourse());
                student.setHobbies(updatedStudent.getHobbies());
                return;
            }
        }
    }
}
