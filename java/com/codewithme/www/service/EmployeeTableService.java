package com.codewithme.www.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codewithme.www.modal.EmployeeTable;
import com.codewithme.www.repository.EmployeeTableRepository;

@Service
public class EmployeeTableService {
	
	EmployeeTableRepository employeeTableRepository;
	
	public EmployeeTableService(EmployeeTableRepository employeeTableRepository){
		this.employeeTableRepository=employeeTableRepository;
	}
	
	public EmployeeTable addEmployee(EmployeeTable employeeTable) {
		return employeeTableRepository.save(employeeTable);
	}
	
	public Optional<EmployeeTable> getEmployeeById(int employeeId) {
		return employeeTableRepository.findById(employeeId);
	}
	
	public Iterable<EmployeeTable> getAllEmployees(){
		return employeeTableRepository.findAll();
	}
	
	public EmployeeTable updateEmployeeById(EmployeeTable employeeTable,int empId) {
		Optional<EmployeeTable> byId = employeeTableRepository.findById(empId);
		if(byId.isPresent()) {
			EmployeeTable existingEmployee = byId.get();
			existingEmployee.setEmployeeName(employeeTable.getEmployeeName());
			existingEmployee.setEmployeeEmail(employeeTable.getEmployeeEmail());
			existingEmployee.setEmployeeDepartment(employeeTable.getEmployeeDepartment());
			existingEmployee.setEmployeeSalary(employeeTable.getEmployeeSalary());
			return employeeTableRepository.save(existingEmployee);
		}
		return null;
	}
	
	public void deleteEmployeeById(int empId) {
			 employeeTableRepository.deleteById(empId);				
	}
	

}
