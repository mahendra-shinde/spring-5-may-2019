package com.cg.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.models.Department;
import com.cg.models.Employee;

public class Main {

	public static void main(String[] args) {
		// ApplicationContext is wrapper around BeanFactory
		ApplicationContext context = 
				//ClassPathXml literally means
				// Bean definition is written in XML file
				// And stored in SRC folder!
					new ClassPathXmlApplicationContext("spring.xml");

		Employee emp = context.getBean(Employee.class);
		Department dept = context.getBean(Department.class);
		System.out.println("Hi "+emp.getFirstName());
		System.out.println("Is emp.department and dept are Same ? "
				+ (emp.getDepartment()==dept));
	}

}
