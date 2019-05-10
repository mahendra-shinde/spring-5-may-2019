package com.cg.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Calculator calc = context.getBean(Calculator.class);
		calc.doSum(10, 23);
		
		
	}

}
