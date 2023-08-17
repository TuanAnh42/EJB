package com.example.compute.service;

import com.example.compute.entity.Computer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class ComputerImpl  implements ComputerService{
        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public void addComputer(Computer computer) {
            entityManager.persist(computer);
        }

        @Override
        public void updateComputer(Computer computer) {
            entityManager.merge(computer);
        }

        @Override
        public void deleteComputer(long computerId) {
            Computer computer = entityManager.find(Computer.class, computerId);
            if (computer != null) {
                entityManager.remove(computer);
            }
        }

        @Override
        public List<Computer> getAllComputers() {
            return entityManager.createQuery("SELECT c FROM Computer c", Computer.class)
                    .getResultList();
        }
    }


