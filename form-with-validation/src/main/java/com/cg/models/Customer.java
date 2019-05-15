package com.cg.models;

import javax.validation.constraints.*;

public class Customer {
	
	@NotNull(message="Please enter Customer ID")
	private Integer customerId;
	
	@NotEmpty(message="Please enter firstname")
	@Size(min=3, max=20, message="Must contains atleast 3 and atmost 20 characters")
	private String firstName;

	//Optional fields
	private String lastName;
	//Optional fields
	private String address;
	
	@Email(message="Invalid email address")
	private String email;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
