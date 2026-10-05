package com.codewithme.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithme.www.modal.EmployeeTask;

@Repository
public interface EmployeeTaskRepository extends JpaRepository<EmployeeTask,Integer>{
	List<EmployeeTask> findByEmployeeTableEmployeeId(int employeeId);
}
