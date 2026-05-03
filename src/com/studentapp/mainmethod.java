package com.studentapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class mainmethod {
	public static List<Student> studentlist=new ArrayList<Student>();
	public static void main(String[] args) {
		System.out.println("STUDENT MANAGEMENT CLASS");
		Student s=new Student("Varsha krishna", 30, "S-123");
		
		studentlist.add(s);
		s.enrollCourse("JAVA");
		s.enrollCourse("javascript");
		s.enrollCourse("sql");
		System.out.println(s);
		s.printStudentInfo();
		studentlist.add(s);
		
		Student result=findstudentbyid("s-123");
		Student s1=new Student("Apramey S", 34, "S-120");
		s1.enrollCourse("JAVA");
		s1.enrollCourse("javascript");
		studentlist.add(s1);
		System.out.println(s1);
		
		
		
		Student s2=new Student("Beena w", 44, "S-121");
		s2.enrollCourse("JAVA");
		s2.enrollCourse("javascript");
		studentlist.add(s2);
		System.out.println(s2);
		System.out.println("Result details "+result);
		studentsort();
		
		
		
		
		
		
		
		
		
		
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
	
	public static Student findstudentbyid(String sid) {
		Student res = null;
		try {
		 res=studentlist.stream().filter(x->x.getStudentId().equalsIgnoreCase(sid)).findFirst()
		.orElseThrow(()-> new RuntimeException("no data found"));
		
		}
		catch (Exception e) {
			System.out.println("No data is found");
		}
		return res;
		
	}
	
	

}
