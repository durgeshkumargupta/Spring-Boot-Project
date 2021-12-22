package com.durgesh;


public class Student {
	private String name;
	private String dept;
	
	
	public Student() {
	}
	public Student(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", dept=" + dept + "]";
	}
	

}
