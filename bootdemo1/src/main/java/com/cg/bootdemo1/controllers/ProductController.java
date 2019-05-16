package com.cg.bootdemo1.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bootdemo1.entities.Product;

@RestController
public class ProductController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello World";
	}
	
	// http://localhost:8080/all-products
	@GetMapping("/all-products")
	public List<Product> products(){
		List<Product> ps = new LinkedList<>();
		Product p1 = new Product();
		p1.setDescription("Sample product1");
		p1.setName("product1");
		p1.setPrice(120D);
		p1.setProductId("P01");
		ps.add(p1);
		Product p2 = new Product();
		p2.setDescription("Sample product2");
		p2.setName("product2");
		p2.setPrice(152.3D);
		p2.setProductId("P02");
		ps.add(p2);
		return ps;
	}
}
