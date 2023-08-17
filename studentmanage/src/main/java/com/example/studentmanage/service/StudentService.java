package com.example.studentmanage.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {
    void add(Student obj);
    void update(Student obj);

    Student getOneById(int id);

    List<Student> getAll();

    void delete(int id);

}
