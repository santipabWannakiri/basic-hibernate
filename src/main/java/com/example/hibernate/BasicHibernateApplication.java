package com.example.hibernate;

import com.example.hibernate.model.Instructor;
import com.example.hibernate.model.InstructorDetail;
import com.example.hibernate.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BasicHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicHibernateApplication.class, args);
    }

    private InstructorService instructorService;

    @Autowired
    public BasicHibernateApplication(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @Bean
    public CommandLineRunner initialInstructor(String[] args) {
        return runner -> {
            createInstructorObject();
        };
    }

    private void createInstructorObject() {
        InstructorDetail instructorDetailA = new InstructorDetail("https://youtube.com/somsak.s", "Cycling");
        Instructor instructorA = new Instructor("SOMSAK", "SANDEE", "SOMSAK.S@gmail.com", instructorDetailA);

        InstructorDetail instructorDetailB = new InstructorDetail("https://youtube.com/somchai", "Singing");
        Instructor instructorB = new Instructor("SOMCHAI", "RIT", "SOMCHAI.R@gmail.com", instructorDetailB);

        InstructorDetail instructorDetailC = new InstructorDetail("https://youtube.com/jirapon", "Tiktoker");
        Instructor instructorC = new Instructor("JIRAPON", "KIM", "JIRAPON.K@gmail.com", instructorDetailC);

        instructorService.save(instructorA);
        instructorService.save(instructorB);
        instructorService.save(instructorC);

        instructorService.persistEntityLifecycleTesting();
//        instructorService.refreshEntityLifecycleTesting();
//        instructorService.detachEntityLifecycleTesting();
//        instructorService.mergeEntityLifecycleTesting();
//        instructorService.removeEntityLifecycleTesting();
    }
}
