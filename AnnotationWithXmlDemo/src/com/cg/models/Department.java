package com.cg.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("department")
public class Department {

	@Value("QA")
	private String name;
	
	@Value("Mumbai")
	private String location;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
