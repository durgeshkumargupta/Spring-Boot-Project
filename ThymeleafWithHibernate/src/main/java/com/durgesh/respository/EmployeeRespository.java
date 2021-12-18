package com.durgesh.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durgesh.model.Employee;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Long> {

	List<Employee> findAll();
	

}
