package com.cg.restparamdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	// Test URL: http://localhost:8080/hello?name=mahendra
	@GetMapping("/hello")
	public String testParam
		(@RequestParam String name) {
		return "Hello "+name;
	}
	
	// Test URL: http://localhost:8080/say-hi-mahendra
	@GetMapping("/say-hi-{name}")
	public String testPathVariable(@PathVariable String name) {
		return "Aye aye captain "+name; 
	}
}
