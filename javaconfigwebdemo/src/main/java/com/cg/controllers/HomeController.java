package com.cg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/") //Home page or Welcome page
public class HomeController {

	@GetMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home",
				"message","Welcome to Spring MVC");
		return mv;
	}
}
