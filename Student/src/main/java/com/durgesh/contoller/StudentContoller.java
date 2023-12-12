package com.durgesh.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.entities.Student;
import com.durgesh.service.impl.StudentServiceImpl;

@RestController
public class StudentContoller {

	@Autowired
	private StudentServiceImpl serviceImpl;
	
	@PostMapping("/save-student")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		return serviceImpl.saveStudent(student);
	}
	
	@GetMapping("/get-student")
	public ResponseEntity<List<Student>> getStudent(){
		return serviceImpl.getStudent();
	}
	
	@PutMapping("/update-student")
	public ResponseEntity<String> updateStudent(@RequestBody Student student){
		return serviceImpl.updateStudent(student);
	}
	
	@DeleteMapping("/delete-student/{id}") //localhost:4040/delete-student/2
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
		return serviceImpl.deleteStudent(id);
	}
	
	@GetMapping("/get-student-id")//localhost:4040/get-student-id?id=3
	public ResponseEntity<Optional<Student>> getStudentById(@RequestParam(required = true) Integer id){
		return serviceImpl.getStudentById(id);
	}
	
}
