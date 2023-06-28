package com.example.hibernate.controller;

import com.example.hibernate.model.Instructor;
import com.example.hibernate.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstructorController {
    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructor")
    public Instructor getInstructorById(@RequestParam("id") int id) {
        return instructorService.findById(id);
    }

    @GetMapping("/instructors")
    public List<Instructor> getListInstructor() {
        return instructorService.findAll();
    }

    @DeleteMapping("/instructor")
    public String deleteInstructorById(@RequestParam("id") int id) {
        instructorService.deleteById(id);
        return "Instructor ID : " + id + " has deleted";

    }
}
