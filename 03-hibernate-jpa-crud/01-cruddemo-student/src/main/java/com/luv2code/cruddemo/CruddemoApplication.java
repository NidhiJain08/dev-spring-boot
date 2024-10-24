package com.luv2code.cruddemo;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner-> {
			//multipleStudent(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object");
		Student tempStudent=new Student("Hanu","gupta","hanu@gmail.com");

		//save the student
		System.out.println("saving the student");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId=tempStudent.getId();
		System.out.println("Generated id is:" + theId);

		//retrieve the student based on Id
		System.out.println("Retrieving student with id:"+theId);
		Student myStudent=studentDAO.findById(theId);

		//display student
		System.out.println("student is "+myStudent);

	}

	private void multipleStudent(StudentDAO studentDAO) {
		//creating student object
		System.out.println("Creating student objects");
		Student tempStudent1=new Student("John","Jain","john@gmail.com");
		Student tempStudent2=new Student("Paul","George","paul@gmail.com");
		Student tempStudent3=new Student("Chris","Jacob","chris@gmail.com");


		//save the student object
		System.out.println("saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		//display id of the saved item
		System.out.println("id of student 1 is "+tempStudent1.getId());
		
	}
}
