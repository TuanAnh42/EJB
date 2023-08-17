package com.example.studentmanage.bean;


import com.example.demo.entity.Student;
import com.example.demo.session.StudentSessionBeanLocal;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;

import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
@Getter
@Setter
public class StudentBean implements Serializable {
    private int id;
    private int age;
    private String name, email;

    @EJB
    private StudentSessionBeanLocal studentLocal;

    public List<Student> getStudentList(){
        return studentLocal.getAll();
    }


    public String add(){
        Student s = new Student(name, email, age);
        studentLocal.add(s);

        return "list?faces-redirect=true";
    }
    public String update(){
        Student s = new Student(rollnumber, name, email, age);
        studentLocal.update(s);
        return "list?faces-redirect=true";
    }

    public String deleteStudent(int id){
        studentLocal.deleteStudent(id);
        return "list?faces-redirect=true";
    }

    public void getOne(int id){
        Student s = studentLocal.getOneById(id);
        age = s.getAge();
        name = s.getName();
        email = s.getEmail();
    }
}
