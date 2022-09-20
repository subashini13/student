package com.microservices.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

/**
 * List to hold all the student details. Used to display on GET method.
 * @author User
 *
 */
@Configuration
public class StudentList {

	List<Student> studentList;

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public StudentList() {
		if (studentList == null) {
			ArrayList<Student> s = new ArrayList<Student>();
			this.studentList = s;
		}

	}

	public StudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

}
