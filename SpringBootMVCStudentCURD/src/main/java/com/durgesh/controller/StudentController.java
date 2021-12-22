package com.durgesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.durgesh.model.Student;
import com.durgesh.repository.StudentRepository;
import com.durgesh.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public String viewPage(Model model) {
		model.addAttribute("listStudent", studentService.getAllStudent());
		return "index";
	}

	@GetMapping("/showFormDelete/{id}")
	public String deleteById(@PathVariable(value = "id") int id) {
		studentService.deleteByIdStudent(id);
		return "redirect:/";

	}

	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/";
	}

	@GetMapping("/saveNewStudentForm")
	public String saveNewStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "new_student";
	}

	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable("id") int id, Model model) {
		Student student = studentService.getById(id);
		studentService.saveStudent(student);

		model.addAttribute("student", student);
		return "update_student";

	}
}
