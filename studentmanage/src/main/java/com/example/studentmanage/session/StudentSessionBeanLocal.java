package com.example.studentmanage.session;

import com.example.demo.entity.Student;
import jakarta.ejb.Local;

import java.util.List;
public interface StudentSessionBeanLocal {

    List<Student> getAll();
    Student getOneById(int id);
    void add(Student obj);
    void update(Student obj);
    void deleteStudent(int id);

}
