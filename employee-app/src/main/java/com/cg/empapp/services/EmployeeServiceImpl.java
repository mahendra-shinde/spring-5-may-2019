package com.cg.empapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.empapp.dao.EmployeeDAO;
import com.cg.empapp.entities.Employee;

@Service
public class EmployeeServiceImpl 
	implements EmployeeService {

	@Autowired private EmployeeDAO dao;
	
	@Override
	public void save(Employee emp) {
		System.out.println("Saving employee: "+emp.getEmpId());
		dao.save(emp);
	}

	@Override
	public Employee findById(Integer id) {
		System.out.println("Finding employee: "+id);
		return dao.findById(id);
	}

	@Override
	public void update(Employee emp) {
		System.out.println("Updating employee: "+emp.getEmpId());
		dao.update(emp);
	}

	@Override
	public void delete(Integer id) {
		System.out.println("Deleting employee: "+id);
		dao.delete(id);
	}

}
