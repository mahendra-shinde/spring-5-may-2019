package com.cg.bootdemo2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bootdemo2.entities.Movie;
import com.cg.bootdemo2.services.MovieService;

@RestController
public class MovieController {

	@Autowired private MovieService service;
	
	// http://localhost:5000/find?id=10023
	@GetMapping("/find")
	public Movie find(@RequestParam("id") Integer id) {
		System.out.println("Search for movie by id "+id);
		Movie m = service.findById(id);
		return m;
	}
}
