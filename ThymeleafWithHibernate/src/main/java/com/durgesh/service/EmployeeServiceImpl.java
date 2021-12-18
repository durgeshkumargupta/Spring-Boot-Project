package com.durgesh.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgesh.model.Employee;
import com.durgesh.respository.EmployeeRespository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRespository employeeRespository;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRespository.findAll();
	}


	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRespository.save(employee);
		
	}


	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional=employeeRespository.findById(id);
		Employee employee=null;
		if(optional.isPresent())
			employee=optional.get();
		else
			throw new RuntimeException("Employee not found for id :"+id);
		return employee;
	}


	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRespository.deleteById(id);
	}

}
