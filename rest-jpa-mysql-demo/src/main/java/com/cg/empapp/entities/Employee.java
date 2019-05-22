package com.cg.empapp.entities;

import javax.persistence.*;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Mark this class for XML conversion
@Entity
@Table(name="employees")
public class Employee implements Serializable{

	@Id @Column(name="emp_id")
	private Integer empId;
	
	@Column(name="first_name",length=20)
	private String firstName;
	
	@Column(name="last_name",length=20)
	private String lastName;
	
	@Column(name="designation",length=20)
	private String designation;
	
	private Double salary;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer empId, String firstName, String lastName, String designation, Double salary) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.salary = salary;
	}
	
	
}
