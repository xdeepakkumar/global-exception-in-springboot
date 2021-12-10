package com.globalexceptionhandling.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.globalexceptionhandling.model.Employee;

@Service
public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Long employeeId);

	public void deleteEmployeeById(Long employeeId);
}
