package com.example.studentmanage.service;

import com.example.demo.entity.Student;
import jakarta.ejb.TransactionAttribute;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    @Override
    public void add(Student obj) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(obj);
        et.commit();

        em.close();
    }

    @Override
    public void update(Student obj) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.merge(obj);
        et.commit();

        em.close();
    }

    @Override
    public Student getOneById(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("select e from Student e where id = :id", Student.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }finally {
            em.close();
        }
    }

    @Override
    public List<Student> getAll() {
        EntityManager em = emf.createEntityManager();

        List<Student> list = em.createQuery("select e from Student e", Student.class).getResultList();

        em.close();
        return list;
    }

    @Override
    @TransactionAttribute
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Student s = em.find(Student.class, id);

        if(s != null) {
            em.remove(s);
            et.commit();
        }
        em.close();
    }
}
