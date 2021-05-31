package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student_info")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer usn;
	
	@Column(name="name")
	private String name;
	
	@Column(name="course")
	private String course;

	public User() {
		
	}
	
	public User( String name, String course) {
		super();
		this.name = name;
		this.course = course;
	}

	public Integer getUsn() {
		return usn;
	}

	public void setUsn(Integer usn) {
		this.usn = usn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return "User [usn=" + usn + ", name=" + name + ", course=" + course + "]";
	}
	
	
	

}
