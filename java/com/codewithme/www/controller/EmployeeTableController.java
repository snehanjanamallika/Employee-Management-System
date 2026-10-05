package com.codewithme.www.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithme.www.modal.EmployeeTable;
import com.codewithme.www.service.EmployeeTableService;

@RestController
public class EmployeeTableController {
	
	
	EmployeeTableService employeeTableService;
	
	public EmployeeTableController(EmployeeTableService employeeTableService) {
		this.employeeTableService=employeeTableService;
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody EmployeeTable employeeTable) {
		employeeTableService.addEmployee(employeeTable);
		return "Employee added succesfully";
	}
	
	@GetMapping("/getEmployee/{employeeId}")
	public Optional<EmployeeTable> getEmployee(@PathVariable int employeeId) {
		return employeeTableService.getEmployeeById(employeeId);
	}
	
	@GetMapping("/getAllEmployees")
	public Iterable<EmployeeTable> getAllEmployees(){
		return employeeTableService.getAllEmployees();
	}
	
	@PutMapping("/updateEmployeeById/{employeeId}")
	public EmployeeTable updateEmployeeById(@PathVariable int employeeId, @RequestBody EmployeeTable employeeTable){
		return employeeTableService.updateEmployeeById(employeeTable,employeeId);
	}
	
	@DeleteMapping("/deleteById/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId) {
		employeeTableService.deleteEmployeeById(employeeId);
		return "Employee deleted succesfully";
	}
}
