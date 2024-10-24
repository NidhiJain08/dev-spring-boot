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
			multipleStudent(studentDAO);
		};
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
