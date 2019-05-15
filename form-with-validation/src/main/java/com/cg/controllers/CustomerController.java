package com.cg.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.models.Customer;

@Controller
public class CustomerController {

	// Method to Accept HTTP GET request on URL that ends with
	// /add-customer.obj
	// Create one EMPTY customer object and send it to
	// a Form page
	@RequestMapping(value="/add-customer.obj",
			method=RequestMethod.GET)
	public ModelAndView showForm() {
		ModelAndView mv = new ModelAndView("form");
		Customer customer = new Customer();
		mv.addObject("customer",customer);
		return mv;
	}
	
	// Method to Accept HTTP POST request on URL that ends with
	// /add-customer.obj
	// accept the Customer object with All properties filled
	// and return to success page
	@RequestMapping(value="/add-customer.obj",method=RequestMethod.POST)
	public ModelAndView submitForm(
			@Valid @ModelAttribute("customer") Customer customer,
			BindingResult result) {
		
		
		ModelAndView mv = null;
		System.out.println("Accepting customer object: ");
		
		if(result.hasErrors()) {
			mv = new ModelAndView("form");
			//Copy all error messages to form page
			mv.addObject(result.getModel());
		}
		else {
		mv = new ModelAndView("success");
		mv.addObject("customer",customer);
		mv.addObject("message","Your request has been accepted!");
		}
		return mv;
	}
	
}
