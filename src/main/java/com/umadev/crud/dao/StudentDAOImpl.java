package com.umadev.crud.dao;

import jakarta.persistence.TypedQuery;
import java.util.List;

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
    // Needs transactional since will modify the db
    @Override
    @Transactional
     public void save(Student theStudent) {
        entityManager.persist(theStudent);
     }

    // Implement reading method
     @Override
     public Student findById(Integer id) {
         return entityManager.find( Student.class, id);
     }

    // Implement reading method (search)
    @Override
    public List<Student> findAll() {
        // Create query USING JPA ENTITY CLASS NAME
        // In the order operation REFER to the FIELD OF JPA ENTITY (lastName)
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName desc", Student.class);

        // Return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // Create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                                    "FROM Student WHERE lastName=:theData" , Student.class);

        // Set the query parameters
        theQuery.setParameter("theData", theLastName);

        // Return results
        return theQuery.getResultList();
    }

    // Needs transactional since will modify database (write)
    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    // Needs transactional since will modify database (delete)
    @Override
    @Transactional
    public void delete(Integer id) {
        // Retrieve the Student
        Student theStudent = entityManager.find(Student.class, id);

        //Delete the student
        entityManager.remove(theStudent);
    }

    // Needs transactional since will modify database (delete)
    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
