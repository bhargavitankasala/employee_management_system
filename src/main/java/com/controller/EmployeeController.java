package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.Employee;
import com.services.EmployeeService;

@Controller
public class EmployeeController {


	@Autowired
	private EmployeeService  employeeService;

	public  EmployeeController( EmployeeService  employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public String listEmployee(Model model)
	{
		model.addAttribute("employees",employeeService.getAllemployees());
		return "employees";
	}

	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model)
	{
		 Employee employee = new  Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}

	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("student")  Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model)
	{
	model.addAttribute("employee",employeeService.getEmployeeById(id));
	return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee)
	{
		//get student from database by id
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());

		//save updated student object
		employeeService.updateEmployee(existingEmployee);
		return "redirect:/employees";


	}

	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id)
	{
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}


}