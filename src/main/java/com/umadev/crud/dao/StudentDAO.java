package com.umadev.crud.dao;

import com.umadev.crud.entity.Student;
import java.util.List;

public interface StudentDAO {
    // Method for creating
    void save(Student theStudent);

    // Method for reading (searching)
    Student findById(Integer id);

    // Method for reading (searching)
    List<Student> findAll(); 
}
