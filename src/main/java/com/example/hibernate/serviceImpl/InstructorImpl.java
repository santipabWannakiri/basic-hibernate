package com.example.hibernate.serviceImpl;

import com.example.hibernate.model.Instructor;
import com.example.hibernate.model.InstructorDetail;
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

    @Override
    @Transactional
    public void detachEntityLifecycleTesting() {
    Instructor detachInstructorTesting = entityManager.find(Instructor.class,1);
    entityManager.detach(detachInstructorTesting);
    detachInstructorTesting.setFirst_name("Detach-state");
    }

    @Override
    @Transactional
    public void mergeEntityLifecycleTesting() {
        Instructor mergeInstructorTesting = entityManager.find(Instructor.class,1);
        entityManager.detach(mergeInstructorTesting);
        mergeInstructorTesting.setFirst_name("Merge=detach-->persist");
        entityManager.merge(mergeInstructorTesting);
    }

    @Override
    @Transactional
    public void persistEntityLifecycleTesting() {
        InstructorDetail persistInstructorDetailTesting = new InstructorDetail("https://youtube.com/transient.n", "Cycling");
        Instructor persisInstructorTesting = new Instructor("Transient-new-state", "New", "transient.n@gmail.com", persistInstructorDetailTesting);
        entityManager.persist(persisInstructorTesting);
        persisInstructorTesting.setFirst_name("Managed-persist-state");
    }

    @Override
    @Transactional
    public void removeEntityLifecycleTesting() {
        Instructor removeInstructorTesting = entityManager.find(Instructor.class,1);
        entityManager.remove(removeInstructorTesting);

    }

    @Override
    @Transactional
    public void refreshEntityLifecycleTesting() {
        Instructor refreshInstructorTesting = entityManager.find(Instructor.class,1);
        refreshInstructorTesting.setFirst_name("New instructor");
        System.out.println(refreshInstructorTesting.getFirst_name());
        entityManager.refresh(refreshInstructorTesting);
        System.out.println(refreshInstructorTesting.getFirst_name());

    }
}
