package com.codewithme.www.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codewithme.www.modal.EmployeeTask;
import com.codewithme.www.repository.EmployeeTaskRepository;

@Service
public class EmployeeTaskService {
	
	EmployeeTaskRepository employeeTaskRepository;
	
	public EmployeeTaskService(EmployeeTaskRepository employeeTaskRepository) {
		this.employeeTaskRepository=employeeTaskRepository;
	}
	
	public EmployeeTask addEmployeeTask(EmployeeTask employeeTask) {
		return employeeTaskRepository.save(employeeTask);
	}
	
	public List<EmployeeTask> getEmployeeTaskByEmployeeId(int employeeId) {
	    return employeeTaskRepository.findByEmployeeTableEmployeeId(employeeId);
	}

	public Iterable<EmployeeTask> getAllEmployeesTask(){
		return employeeTaskRepository.findAll();
	}
	
	public EmployeeTask updateEmployeeTaskById(EmployeeTask employeeTask,int taskId){
		Optional<EmployeeTask> byId = employeeTaskRepository.findById(taskId);
		if(byId.isPresent()) {
			EmployeeTask existingEmployee = byId.get();
			existingEmployee.setTaskTitle(employeeTask.getTaskTitle());
			existingEmployee.setTaskDescription(employeeTask.getTaskDescription());
			existingEmployee.setTaskDuedate(employeeTask.getTaskDuedate());
			existingEmployee.setTaskStatus(employeeTask.getTaskStatus());
			return employeeTaskRepository.save(existingEmployee);
		}
		return null;
	}
	
	public void deleteById(int taskId) {
		employeeTaskRepository.deleteById(taskId);
	}
}

