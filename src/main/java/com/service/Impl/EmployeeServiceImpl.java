package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.repository.EmployeeRepository;
import com.services.EmployeeService;


@Service
public class EmployeeServiceImpl  implements EmployeeService{


	@Autowired
	private EmployeeRepository employeeRepository;





	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}





	@Override
	public List<Employee> getAllemployees() {

		return employeeRepository.findAll();
	}





	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}





	@Override
	public Employee getEmployeeById(Long id) {

		return employeeRepository.findById(id).get();
	}





	@Override
	public Employee updateEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}





	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);

	}





	

}

