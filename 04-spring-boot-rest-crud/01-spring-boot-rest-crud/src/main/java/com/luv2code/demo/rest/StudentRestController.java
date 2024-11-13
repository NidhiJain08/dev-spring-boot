package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct // define this to load the student data... only once
    public void loadData(){

        theStudents=new ArrayList<>();

        theStudents.add(new Student("Ram","Jain"));
        theStudents.add(new Student("Hanu","Sharma"));
        theStudents.add(new Student("Jai","Vyas"));
        theStudents.add(new Student("Lakshmi","Jain"));
        theStudents.add(new Student("Sita","Singh"));
        theStudents.add(new Student("Shiv","Kumar"));
    }

    //define endpoint for /students: return list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    //define endpoint or "/students/{studentId}"- return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //check studentId against list size
        if((studentId>= theStudents.size()) || (studentId<0)){
            throw new StudentNotFoundException(" Student is not found: "+studentId);
        }

        return theStudents.get(studentId);
    }

    //add an exception handler using annotation: @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        //create a StudentErrorResponse
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //adding another exception handler, to catch any exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        //create a StudentErrorResponse
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
