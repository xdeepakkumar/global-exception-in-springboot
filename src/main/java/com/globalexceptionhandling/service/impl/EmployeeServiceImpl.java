package com.globalexceptionhandling.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalexceptionhandling.exceptionAdvice.EmptyInputException;
import com.globalexceptionhandling.model.Employee;
import com.globalexceptionhandling.repository.EmployeeRepository;
import com.globalexceptionhandling.service.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		if(employee.getName().isEmpty() || employee.getName().length() == 0) {
			throw new EmptyInputException("601", "Input fields are empty.");
		}
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		Employee retrievedEmployee = employeeRepository.findById(employeeId).get(); // here using get due to it is returning optional
		return retrievedEmployee;
	}

	@Override
	public void deleteEmployeeById(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}
}
