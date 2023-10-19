package com.services;

import java.util.List;

import com.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllemployees();
	 public Employee saveEmployee(Employee employee);

	public Employee getEmployeeById(Long id);

	
	public Employee updateEmployee(Employee employee);
	public void deleteEmployeeById(Long id);


}
