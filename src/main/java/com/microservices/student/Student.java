package com.microservices.student;

import java.io.Serializable;

import org.springframework.context.annotation.Configuration;
/**
 * POJO to hold the student details.
 * @author User
 *
 */
@Configuration
public class Student implements Serializable {

	private static final long serialVersionUID = 7636586794036692696L;
	String name;
	int roll_no;
	int math_mark;
	int eng_mark;
	int sci_mark;

	public Student() {

	}

	public Student(String name, int roll_no) {
		this.name = name;
		this.roll_no = roll_no;
		this.eng_mark = 20;
		this.math_mark = 20;
		this.sci_mark = 20;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	public int getMath_mark() {
		return math_mark;
	}

	public void setMath_mark(int math_mark) {
		this.math_mark = math_mark;
	}

	public int getEng_mark() {
		return eng_mark;
	}

	public void setEng_mark(int eng_mark) {
		this.eng_mark = eng_mark;
	}

	public int getSci_mark() {
		return sci_mark;
	}

	public void setSci_mark(int sci_mark) {
		this.sci_mark = sci_mark;
	}

}
