package com.durgesh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.durgesh.entities.Student;
import com.durgesh.respository.impl.StudentRepositoryImpl;

@Service
public class StudentServiceImpl {
	
	@Autowired
	private StudentRepositoryImpl studentRepositoryImpl;

	public ResponseEntity<String> saveStudent(Student student) {
		Student stu = studentRepositoryImpl.save(student);
		if(stu == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.CREATED).body("Student Created Successfully");
		}
	}

	public ResponseEntity<List<Student>> getStudent() {
		List<Student> stuList = (List<Student>) studentRepositoryImpl.findAll();
		if(stuList.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		else
			return ResponseEntity.status(HttpStatus.OK).body(stuList);
	}

	public ResponseEntity<String> updateStudent(Student student) {
		Student stu = studentRepositoryImpl.save(student);
		if(stu == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body("Student updated Successfully");
		}
	}

	public ResponseEntity<String> deleteStudent(Integer id) {
		try {
			studentRepositoryImpl.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Student deleted Successfully");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to delete");
		}
	}
	
	public ResponseEntity<Optional<Student>> getStudentById(Integer id) {
		Optional<Student> s = studentRepositoryImpl.findById(id);
		if(s.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		else
			return ResponseEntity.status(HttpStatus.OK).body(s);
	}
	
}
