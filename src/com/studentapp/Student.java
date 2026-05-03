package com.studentapp;

import java.util.ArrayList;
import java.util.List;

public class Student {

	
	private String name;
	private int age;
	private String studentId;
	private List<String> courses=new ArrayList<String>();
	public Student(String name, int age, String studentId) {
		super();
		if(validateage(age) && validatename(name) && validatestudentid(studentId)) {
		
		this.name = name;
		this.age = age;
		this.studentId = studentId;
		
	}
	}
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}







	public void setName(String name) {
		this.name = name;
	}







	public int getAge() {
		return age;
	}







	public void setAge(int age) {
		this.age = age;
	}







	public String getStudentId() {
		return studentId;
	}







	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}







	public List<String> getCourses() {
		return courses;
	}







	public void setCourses(List<String> courses) {
		this.courses = courses;
	}







	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}


	public void enrollCourse(String course) {
		
		if(courses.contains(course)) {
			System.out.println("The course has been already enrolled"+ course);
		}
		else if(validatenrolledcourse(course))
		courses.add(course);
		System.out.println("Student is enrolled successfully");
	}
	
	
	
	public void printStudentInfo() {
		System.out.println("student’s name"+name);
		System.out.println("student’s age"+age);
		System.out.println("student’s ID"+studentId);
		System.out.println("student’s enrolled course"+courses);
		
	}
	
	//Validation methods
	
	
	
	
	//Validation of age
	public boolean validateage(int age) {
		if(age>=18 && age<=50) {
			return true;
		}
		else
			System.out.println("Invalid student age");
		return false;
	}
	
	//Validation of name
	
	public boolean validatename(String name) {
		if(name.matches("^[A-Za-z\\s]+$")) {
			return true;
		}
		else
			System.out.println("Invalid student name");
		return false;
	}
	
	
	//Validation of student id
	
		public boolean validatestudentid(String id) {
			if(id.matches("S-[0-9]+$")) {
				return true;
			}
			else
				System.out.println("Invalid student id");
			return false;
		}
		
	
		//Validation of enrolled course
		
		
		public boolean validatenrolledcourse(String course) {
			if(course.equalsIgnoreCase("Java")|| course.equalsIgnoreCase("Python")||course.equalsIgnoreCase("Javascript")) {
				return true;
			}
			else
				System.out.println("Invalid course ");
			return false;
		}
	
	
	
	
}
