package com.cg.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.models.Employee;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring.xml");
		Employee e = context.getBean(Employee.class);
		System.out.println(e.getFirstName());
		System.out.println(e.getDepartment().getLocation());
	}

}
