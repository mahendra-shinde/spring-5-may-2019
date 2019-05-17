package com.cg.empapp.dao;

import com.cg.empapp.entities.Employee;

public interface EmployeeDAO {
	void save(Employee emp);
	Employee findById(Integer id);
	void delete(Integer id);
	void update(Employee emp);
}
