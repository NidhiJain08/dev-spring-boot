package com.luv2code.cruddemo;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner-> {
			//multipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("deleting all students");
		int numRowsDeleted=studentDAO.deleteAll();
		System.out.println("number of rows deleted: "+ numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO){
		int studentId=3;

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO){
		int studentId=1;
		Student myStudent=studentDAO.findById(studentId);
		System.out.println("updating student");

		//changes first name to Nidhi
		myStudent.setFirstName("Nidhi");
		studentDAO.update(myStudent);

		//display updated student
		System.out.println("Updated student: "+ myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of Students
		List<Student> theStudents=studentDAO.findByLastName("Gupta");

		//display list of students
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents=studentDAO.findAll();

		//display list of students
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
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
