package com.codewithme.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithme.www.modal.EmployeeTable;

@Repository
public interface EmployeeTableRepository extends JpaRepository<EmployeeTable,Integer>{

}
