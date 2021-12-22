package com.durgesh;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan("com.durgesh")
@Component
public class Student 
{
	private String usn;
	private String name;
	private String college_name;
	private String dept;
	
	public Student() {
		
	}
	
	public Student(String usn, String name, String college_name, String dept) {
		this.usn = usn;
		this.name = name;
		this.college_name = college_name;
		this.dept = dept;
	}

	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Student [usn=" + usn + ", name=" + name + ", college_name=" + college_name + ", dept=" + dept + "]";
	}
	

}
