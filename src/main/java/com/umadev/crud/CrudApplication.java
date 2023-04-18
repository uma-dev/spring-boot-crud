package com.umadev.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.umadev.crud.dao.StudentDAO;
import com.umadev.crud.entity.Student;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			// readStudent (studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO );

			// updateStudent(studentDAO);
			
			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

    private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count:  " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
        // Retrieve student based on the ID: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// Change first name to "newName"
		System.out.println("Updating student ...");
		myStudent.setFirstName("newName");
		studentDAO.update(myStudent);

		// Update the student
		studentDAO.update(myStudent);

		// Display the updated student
		System.out.println("Updated student: " + myStudent);
    }

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// Get list of Students
		List<Student> theStudents = studentDAO.findByLastName("lastName3");

		// Display list of Students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// Get list of students
		List<Student> theStudents = studentDAO.findAll();

		// Display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// Create student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student( "name" , "lastName", "student@domain.com");

		// Save the student
		System.out.println("Saving new student ");
		studentDAO.save(tempStudent);

		// Display the ID of the student
		int theId = tempStudent.getId();
		System.out.println("Saved student with ID: " + theId);

		// Retrieve student based on the ID
		System.out.println("Retrieving student with ID: ");
		studentDAO.findById(theId);

		// Display the student
		System.out.println("Found the student: " + theId);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// Create the student object 
		System.out.println("Creating 3 students object");
		Student tempStudent1 = new Student( "name1" , "lastName1", "student@domain.com");
		Student tempStudent2 = new Student( "name2" , "lastName2", "student@domain.com");
		Student tempStudent3 = new Student( "name3" , "lastName3", "student@domain.com");

		// Save the student object
		System.out.println("Saving students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// Display the ID of the saved student
		System.out.println("Saved student with ID: " + tempStudent1.getId());
		System.out.println("Saved student with ID: " + tempStudent2.getId());
		System.out.println("Saved student with ID: " + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		
		// Create the student object 
		System.out.println("Creating new student object");
		Student tempStudent = new Student( "name" , "lastName", "student@domain.com");

		// Save the student object
		System.out.println("Saving new student");
		studentDAO.save(tempStudent);

		// Display the ID of the saved student
		System.out.println("Saved student with ID: " + tempStudent.getId());
	}
}
