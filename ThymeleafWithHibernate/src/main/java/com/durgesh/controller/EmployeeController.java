package com.durgesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.durgesh.model.Employee;
import com.durgesh.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	//display list of employee
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model)
	{
		//create model attribute to bind form data
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		//save employee to database
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable (value="id") long id,Model model)
	{
		//get employee from the service
		Employee employee=employeeService.getEmployeeById(id);
		//set employee as a model attribute to pre-popu;ate the from
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/showFormDelete/{id}")
	public String showFormDelete(@PathVariable (value="id") long id)
	{
		employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
}
