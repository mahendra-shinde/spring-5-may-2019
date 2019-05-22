package com.cg.empapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.empapp.entities.Employee;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee,Integer>{
	
}
