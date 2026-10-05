package com.codewithme.www.modal;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employeeTask")
public class EmployeeTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	private String taskTitle;
	private String taskDescription;
	private String taskStatus;
	private LocalDate taskDuedate;
	
	 @ManyToOne
	 @JoinColumn(name = "employee_Id")
	 private EmployeeTable employeeTable;
	 
	 

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public LocalDate getTaskDuedate() {
		return taskDuedate;
	}

	public void setTaskDuedate(LocalDate taskDuedate) {
		this.taskDuedate = taskDuedate;
	}

	public void setEmployeeTable(EmployeeTable employeeTable) {
	    this.employeeTable = employeeTable;
	}
}
