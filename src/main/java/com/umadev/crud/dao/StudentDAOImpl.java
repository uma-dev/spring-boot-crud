package com.umadev.crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.umadev.crud.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{
    
    // Define field for entity manager
    private EntityManager entityManager;

    // Inject entity manager using  constructor injection 
    @Autowired
    public StudentDAOImpl( EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement save method
    @Override
    @Transactional
     public void save(Student theStudent) {
        entityManager.persist(theStudent);
     }
}
