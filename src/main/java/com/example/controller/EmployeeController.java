package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/findAllEmployees")
	public List<Employee> findAllEmployees() {
		return employeeService.findAllEmployees();
	}
	
	@PostMapping("/saveEmployee")
	public int saveEmployee(@RequestBody final Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
	public void deleteEmployee(@PathVariable final int empId) {
		employeeService.deleteEmployee(empId);
	}
	
	@GetMapping("/loadEmployee/{empId}")
	public Employee loadEmployee(@PathVariable final int empId) {
		return employeeService.loadEmployee(empId);
	}
	
	@PutMapping("/updateEmployee")
	public void updateEmployee(@RequestBody final Employee employee) {
		employeeService.updateEmployee(employee);
	}
	
}
