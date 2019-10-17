package com.someone.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.someone.example.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	
}
