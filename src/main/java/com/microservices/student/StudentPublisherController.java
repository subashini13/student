package com.microservices.student;

import java.util.ArrayList;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller to accept the student details and display the result on GET method.
 * Sample input 
 * @author User
 *
 */
@RestController
@RequestMapping("/student")
public class StudentPublisherController {

	public StudentPublisherService studentPublisherService;
	public StudentList studentList;

	public StudentPublisherController(StudentPublisherService StudentPublisherService, StudentList studentList,
			StudentPublisherService studentPublisherService) {
		this.studentPublisherService = studentPublisherService;
		if (studentList.getStudentList() == null) {
			ArrayList<Student> s = new ArrayList<Student>();
			studentList.setStudentList(s);

		}
		this.studentList = studentList;
	}
	/**
	 * Method to accept the student details and publish it on a topic
	 * sample url : http://localhost:8080/student/add/James/1/23/23/23
	 * @param name
	 * @param id
	 * @param sci
	 * @param math
	 * @param eng
	 * @return
	 */
	@GetMapping("/add/{name}/{id}/{math}/{sci}/{eng}")
	public String addStudent(@PathVariable("name") String name, @PathVariable("id") int id,
			@PathVariable("sci") int sci, @PathVariable("math") int math, @PathVariable("eng") int eng) {

		Student student = new Student();

		student.setName(name);
		student.setRoll_no(id);
		student.setSci_mark(sci);
		student.setEng_mark(eng);
		student.setMath_mark(math);
		studentList.getStudentList().add(student);
		studentPublisherService.sendStudentDetails(student);

		return "Student Details Added";
	}
	/**
	 * sample url : http://localhost:8080/student/get/
	 * 
	 * Method to display all the student details added.
	 * @return
	 */
	@GetMapping("/get")
	public List<Student> getStudentList() {

		return studentList.getStudentList();
	}

}
