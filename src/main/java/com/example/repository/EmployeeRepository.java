package com.example.repository;

import java.util.List;

public interface EmployeeRepository {

	public List<Employee> findAllEmployees();
	
	public int saveEmployee(final Employee employee);
	
	public Employee loadEmployee(final int empId);
	
	public void deleteEmployee(final int empId);
	
	public void updateEmployee(final Employee employee);
	
}
