package com.cg.empapp.services;

import com.cg.empapp.entities.Employee;

public interface EmployeeService {
	void save(Employee emp);
	Employee findById(Integer id);
	void update(Employee emp);
	void delete(Integer id);
}
