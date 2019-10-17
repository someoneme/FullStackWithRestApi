package com.someone.example.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.someone.example.model.*;
import com.someone.example.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestController {

	EmployeeRepository employeeRepository;

	public TestController(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping("/employeess")
	List<Employee> all(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employee/{id}")
	Employee singleEmployee(@PathVariable Long id){
		return employeeRepository.findById(id).orElse(new Employee());
	}
	
	@PutMapping("/employee/{id}")
	Employee putEmployee(@PathVariable Long id, @RequestBody Employee newEmployee) {
		return employeeRepository.findById(id).orElse(employeeRepository.save(newEmployee));
	}
	
	@DeleteMapping("/employee/{id}")
	Optional<Employee> deleteEmployee(@PathVariable Long id) {
		Optional<Employee> employeee = employeeRepository.findById(id);
		if(employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
//			return "Deleted";
			
		}
		return employeee;
//		else {
//			return "Employee does not exist";
//		}
	}
	
}
