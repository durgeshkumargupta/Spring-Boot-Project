package com.durgesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgesh.model.Student;
import com.durgesh.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public void deleteByIdStudent(int id) {
		studentRepository.deleteById(id);
	}

	public void updateById(Student student) {
		studentRepository.save(student);

	}

	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	public Student getById(int id) {
		return studentRepository.getById(id);
	}

}
