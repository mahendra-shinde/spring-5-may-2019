package com.cg.empapp.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.cg.empapp.entities.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private Map<Integer, Employee> empData = new HashMap<>();
	
	@PostConstruct public void initSampleData() {
		System.out.println("Preparing sample data...");
		empData.put(1001, new Employee(1001, "Priyanka", "Jonas", "Actress", 12300D));
		empData.put(1002, new Employee(1002,"Joe","Jonas","Pop star",234400D));
		empData.put(1003, new Employee(1003, "Sachin","Tendulkar","Sportsman",320000D));
	}
	
	@Override
	public void save(Employee emp) {
		if(empData.containsKey(emp.getEmpId())) {
			throw new ApplicationException("Employee already exists!");
		}
		empData.put(emp.getEmpId(),emp);
	}

	@Override
	public Employee findById(Integer id) {
		Employee emp = empData.get(id);
		System.out.println("Found :"+emp.getFirstName());
		
		if(emp==null) {
			throw new ApplicationException("Employee not found!");
		}
		return emp;
	}

	@Override
	public void delete(Integer id) {
		Employee emp = findById(id);
		empData.remove(id);
	}

	@Override
	public void update(Employee emp) {
		Employee old = findById(emp.getEmpId());
		empData.put(emp.getEmpId(),emp);
	}

}
