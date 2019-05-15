package com.cg.javaconfigweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration	//This class is Configuration class
@EnableWebMvc	//This application is Web MVC Application
@ComponentScan("com.cg.controllers")	//Scan all classes and packages
										//for web components 
public class DispatcherConfig {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver 
			= new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
