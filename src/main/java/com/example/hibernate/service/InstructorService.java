package com.example.hibernate.service;

import com.example.hibernate.model.Instructor;

import java.util.List;

public interface InstructorService {

    public void save(Instructor instructor);
    public Instructor findById(int id);
    public List<Instructor> findAll();
    public void deleteById(int id);
}
