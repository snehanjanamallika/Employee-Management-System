package com.codewithme.www.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithme.www.modal.EmployeeTask;
import com.codewithme.www.service.EmployeeTaskService;

@RestController
public class EmployeeTaskController {
	
	
	EmployeeTaskService employeeTaskService;
	
	public EmployeeTaskController(EmployeeTaskService employeeTaskService) {
		this.employeeTaskService=employeeTaskService;
	}
	
	@PostMapping("/addEmployeeTask")
	public EmployeeTask addEmployeeTask(@RequestBody EmployeeTask employeeTask) {
		return employeeTaskService.addEmployeeTask(employeeTask);
	}

	@GetMapping("/getEmployeeTaskByEmployeeId/{employeeId}")
	public List<EmployeeTask> getEmployeeTaskByEmployeeId(@PathVariable int employeeId) {
	    return employeeTaskService.getEmployeeTaskByEmployeeId(employeeId);
	}
	
	@GetMapping("/getAllEmployeesTask")
	public Iterable<EmployeeTask> getAllEmployeesTask(){
		return employeeTaskService.getAllEmployeesTask();
	}
	
	@PutMapping("/updateEmployeeTaskById/{taskId}")
	public EmployeeTask updateEmployeeTaskById(@RequestBody EmployeeTask employeeTask,@PathVariable int taskId) {
		return employeeTaskService.updateEmployeeTaskById(employeeTask, taskId);
	}
	
	@DeleteMapping("/deleteEmployeeTaskById/{taskId}")
	public String deleteEmployeeById(@PathVariable int taskId) {
		employeeTaskService.deleteById(taskId);
		return "EmployeeTask Deleted successfully";
	}
}
