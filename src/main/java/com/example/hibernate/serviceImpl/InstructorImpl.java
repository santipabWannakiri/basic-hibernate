package com.example.hibernate.serviceImpl;

import com.example.hibernate.model.Instructor;
import com.example.hibernate.service.InstructorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorImpl implements InstructorService {

    private EntityManager entityManager;

    @Autowired
    public InstructorImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public List<Instructor> findAll() {
        TypedQuery<Instructor> instructor = entityManager.createQuery("FROM Instructor", Instructor.class);
        return instructor.getResultList();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Instructor objectToDelete = entityManager.find(Instructor.class, id);
        entityManager.remove(objectToDelete);
    }
}
