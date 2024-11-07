package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //define endpoint for /students: return list of students
    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> theStudents=new ArrayList<>();
        theStudents.add(new Student("Ram","Jain"));
        theStudents.add(new Student("Hanu","Sharma"));
        theStudents.add(new Student("Jai","Vyas"));
        theStudents.add(new Student("Lakshmi","Jain"));
        theStudents.add(new Student("Sita","Singh"));
        theStudents.add(new Student("Shiv","Kumar"));

        return theStudents;
    }
}
