package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> myStudents;

    @PostConstruct
    public void loadData()
    {
        myStudents  = new ArrayList<>();
        myStudents.add(new Student("Jain","Shubham"));
        myStudents.add(new Student("Jain","Kishu"));
        myStudents.add(new Student("Mishra","Shivam"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
       return myStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId)
    {
        return myStudents.get(studentId);
    }
}
