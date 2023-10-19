package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Employee;
import com.repository.EmployeeRepository;

@SuppressWarnings("unused")
@SpringBootApplication
public class EmployeeManagementSystem1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystem1Application.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;


	@Override
	public void run(String... args) throws Exception {
		
	}
}

