package com.cg.empapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.empapp.dao.EmployeeDAO;
import com.cg.empapp.entities.Employee;
import com.cg.empapp.exceptions.ApplicationException;

@Service
public class EmployeeServiceImpl 
	implements EmployeeService {

	@Autowired private EmployeeDAO dao;
	
	@Override
	public void save(Employee emp) {
		System.out.println("Saving employee: "+emp.getEmpId());
		if(dao.existsById(emp.getEmpId())) {
			throw new ApplicationException("Record already exists!");
		}
		dao.save(emp);
	}

	@Override
	public Employee findById(Integer id) {
		System.out.println("Finding employee: "+id);
		Optional<Employee> temp = dao.findById(id);
		if(!temp.isPresent()) {
			throw new ApplicationException("Unable to find employee "+id);
		}
		return temp.get();
	}

	@Override
	public void update(Employee emp) {
		System.out.println("Updating employee: "+emp.getEmpId());
		if(! dao.existsById(emp.getEmpId())) {
			throw new ApplicationException("Record did not exists!"); 
		}
		dao.save(emp);
	}

	@Override
	public void delete(Integer id) {
		System.out.println("Deleting employee: "+id);
		if(!dao.existsById(id)) {
			throw new ApplicationException("Unable to delete, record not found!");
		}
		dao.deleteById(id);
	}

}
