package com.learn.hibernate.ex5.HibernateCrud1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student1 {
	@Id
	int rollNo;
	String name;
	int age;
	int marks;
	@Override
	public String toString() {
		return "Student1 [rollNo=" + rollNo + ", name=" + name + ", age=" + age + ", marks=" + marks + "]";
	}
	public Student1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student1(int rollNo, String name, int age, int marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
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
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	

}
