package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager; // Injecting the Entity Manager in our DAO
    }

    @Override
    @Transactional
    public void save(Student theStudent) { // Implementation of save Mtd.
        entityManager.persist(theStudent);//Using Entity Manager to save java object to the database
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }
}
