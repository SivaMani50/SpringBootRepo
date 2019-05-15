package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAllEmployees();
	}
	
	public int saveEmployee(final Employee employee) {
		return employeeRepository.saveEmployee(employee);
	}
	
	public void deleteEmployee(final int empId) {
		employeeRepository.deleteEmployee(empId);
	}
	
	public Employee loadEmployee(final int empId) {
		return employeeRepository.loadEmployee(empId);
	}
	
	public void updateEmployee(final Employee employee) {
		employeeRepository.updateEmployee(employee);
	}
}
