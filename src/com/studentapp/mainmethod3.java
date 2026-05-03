package com.studentapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class mainmethod3 {
	public static List<Student> studentlist=new ArrayList<Student>();
	public static void main(String[] args) {
		

		Scanner s=new Scanner(System.in);
		while(true) {
		System.out.println("STUDENT MANAGEMENT CLASS");
		System.out.println("**************************************************************************************");
		System.out.println("Enter the options");
		System.out.println("1. Register a student");
		System.out.println("2. Find a student with id");
		System.out.println("3. List all the student information");
		System.out.println("4. List all the student information in sorted order");
		System.out.println("5. Exit");
		int option =s.nextInt();
		
		
		switch(option) {
		
		case 1:registerthestudent(s);
				break;
		
		case 2:findstudentbyid(s);
				break;
		case 3:printstudentdata();
				break;
		case 4:studentsort();
				break;
		case 5:exit();
				break;
		default: System.out.println("Enter options between 1-5");
		}
		System.out.println("Good bye!!!!!!!!!!");	
		}
		
	
		
	}
	
	private static void exit() {
		System.exit(0);
		
	}

	private static void printstudentdata() {
		for( Student s:studentlist) {
			s.printStudentInfo();
		}
		
	}

	private static void registerthestudent(Scanner s) {
		
		System.out.println("Enter the name of the student");
		String name=s.next();
		System.out.println("Enter the student id");
		String id=s.next();
		System.out.println("Enter the student age");
		int age=s.nextInt();
		Student s1=new Student(name, age, id);
		while(true) {
		System.out.println("Enter the course to be enrolled");
		String course=s.next();
		if(course.equalsIgnoreCase("done")) {
			break;
		}
		
		s1.enrollCourse(course);
		studentlist.add(s1);
		
	}
		s1.printStudentInfo();
}

	public static void studentsort() {
		
		
		Comparator<Student> studentcompare=new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				
				return o1.getName().compareTo(o2.getName());
			}
		};
		
		Collections.sort(studentlist,studentcompare);
		
		System.out.println(studentlist);
	}
	
	public static void findstudentbyid(Scanner s) {
		Student res = null;
		System.out.println("Enter the student id");
		String sid=s.next();
				try {
		 res=studentlist.stream().filter(x->x.getStudentId().equalsIgnoreCase(sid)).findFirst()
		.orElseThrow(()-> new RuntimeException("no data found"));
		
		}
		catch (Exception e) {
			System.out.println("No data is found");
		}
		
		System.out.println("Student info ");
		res.printStudentInfo();
	}
	
	

}
