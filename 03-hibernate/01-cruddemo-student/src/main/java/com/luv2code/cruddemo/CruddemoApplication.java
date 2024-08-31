package com.luv2code.cruddemo;

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
		return runner->{
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//getAllStudents(studentDAO);
 			//getAllStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleting all...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number of rows deleted "+ numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Now student list looks like...");
		List<Student> theStudents = studentDAO.findAll();
		//display list of students
		for(Student tempStudent: theStudents)
			System.out.println(tempStudent);
		System.out.println("Delete Student id is 1 ");
		System.out.println("Fetching details...");
		int theId=1;
		Student myStudent = studentDAO.findById(theId);
		System.out.println("Student details to be deleted "+ myStudent);
		System.out.println("Deleting student....");
		studentDAO.delete(theId);
		System.out.println("Student deleted successfully");
		System.out.println("Now student list looks like...");
		List<Student> currentStudents = studentDAO.findAll();
		//display list of students
		for(Student tempStudent: currentStudents)
			System.out.println(tempStudent);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//which student to update
		int theId = 1;
		//fetch the current details of student
		System.out.println("Fetching details of Student....");
		Student theStudent = studentDAO.findById(theId);
		System.out.println(theStudent);
		//modify
		theStudent.setFirstName("Shubh");
		//call update interface/implementation
		System.out.println("Updating the details....");
		studentDAO.update(theStudent);
		System.out.println(theStudent);
	}

	private void getAllStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Singh");
		//display list of students
		for(Student tempStudent: theStudents)
			System.out.println(tempStudent);
	}

	private void getAllStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		//display list of students
		for(Student tempStudent: theStudents)
			System.out.println(tempStudent);
	}

	private void readStudent(StudentDAO studentDAO) {
		//create student
		System.out.println("Creating a student...");
		Student tempStudent = new Student("Shubhankar","Singh","shusi@gmail.com");
		//save student
		System.out.println("Saving student to the database...");
		studentDAO.save(tempStudent);
		//get id of saved student
		System.out.println("Retrieving student id...");
		int theid = tempStudent.getId();
		System.out.println("Id of saved student is : "+tempStudent.getId());
		//retrieve student based on id
		System.out.println("Fetching student details from the database...");
		Student myStudent = studentDAO.findById(theid);
		//display student
		System.out.println("Student details: "+myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new Student....");
		Student tempStudent = new Student("Shubham", "Jain", "shubham@luv2code.com");

		// save student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		// display id of saved student
		System.out.println("Id of saved student is : "+tempStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO)
	{
		//create multiple students
		System.out.println("Creating 3 new Students....");
		Student tempStudent1 = new Student("Nidhi", "Jain", "nidhi@luv2code.com");
		Student tempStudent2 = new Student("Kishu", "Jain", "kishu@luv2code.com");
		Student tempStudent3= new Student("Khushi", "Jain", "khushi@luv2code.com");

		//save the Student objects
		System.out.println("Saving the Students....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
}
