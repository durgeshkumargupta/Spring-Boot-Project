package com.durgesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "college_name")
	private String college_name;

	@Column(name = "department")
	private String department;

	@Column(name = "address")
	private String address;
	@Column(name = "usn")
	private String usn;

	public Student() {
	}

	public Student(Integer id, String name, String college_name, String department, String address, String usn) {
		this.id = id;
		this.name = name;
		this.college_name = college_name;
		this.department = department;
		this.address = address;
		this.usn = usn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college_name=" + college_name + ", department=" + department
				+ ", address=" + address + ", usn=" + usn + "]";
	}

}
