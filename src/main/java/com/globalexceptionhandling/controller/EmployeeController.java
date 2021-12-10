package com.globalexceptionhandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalexceptionhandling.model.Employee;
import com.globalexceptionhandling.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	// save employee
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee savedEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}
	
	// all employee
	@GetMapping("/all-employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){ 
		List<Employee> allEmployees = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
	}
	
	// get employee by id
	@GetMapping("/getEmployeeById/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") Long employeeId){
		Employee employee = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	// get employee by id
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Long employeeId){
		employeeService.deleteEmployeeById(employeeId);
		return new ResponseEntity<String>("Employee deleted successfully.", HttpStatus.ACCEPTED);
	}
	
	// update employee
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee savedEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
	}
}
