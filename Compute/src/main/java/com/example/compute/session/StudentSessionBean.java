package com.example.compute.session;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentServiceImpl;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class StudentSessionBean implements StudentSessionBeanLocal {
    StudentServiceImpl service = new StudentServiceImpl();

    @Override
    public List<Student> getAll() {
        return service.getAll();
    }

    @Override
    public Student getOneById(int id) {
        return service.getOneById(id);
    }

    @Override
    public void add(Student obj) {
        service.add(obj);
    }
    @Override
    public void update(Student obj) {
        service.update(obj);
    }

    @Override
    public void deleteStudent(int id) {
        service.delete(id);
    }

}
