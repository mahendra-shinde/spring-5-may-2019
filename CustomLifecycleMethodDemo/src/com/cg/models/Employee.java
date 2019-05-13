package com.cg.models;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee {
	private String firstName;
	private String lastName;
	private Department department;
	
	
	//@PostConstruct 
	//Method must be PUBLIC, VOID and with ZERO ARGUMENTS
	public void init(){
		System.out.println("After Object Created but"
					+" before its invoked using getBean");
	}
	
	//@PreDestroy
	//Method must be PUBLIC, VOID & No Arguments
	public void destroy(){
		System.out.println("Melodrama at Destroy!");
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
