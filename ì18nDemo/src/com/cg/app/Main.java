package com.cg.app;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("spring.xml");
	
		MessageSource source = context.getBean(MessageSource.class);
		Locale tamil = new Locale("ta", "IN");
		System.out.println(source.getMessage("message",null, tamil));
		Locale hindi = new Locale("hi", "IN");
		System.out.println(source.getMessage("message",null, hindi));
		
		System.out.println(source.getMessage("message",null, Locale.getDefault()));
		
		
		System.out.println("Shutdown the Spring IOC COntainer");
		context.close();
	}

}
