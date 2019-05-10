package com.cg.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean public SimpleDAO dao() {
		return new SimpleDAO();
	}
	
	@Bean public Calculator calc() {
		return new Calculator(dao());
	}
}

