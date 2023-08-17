package com.example.studentmanage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollnumber;
    private String name;


    private String email;

    private int age;
    public Student() {
    }



    public Student(int rollnumber, String name, String email, int age) {
        this.rollnumber = rollnumber;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }


    public int getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(int rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}