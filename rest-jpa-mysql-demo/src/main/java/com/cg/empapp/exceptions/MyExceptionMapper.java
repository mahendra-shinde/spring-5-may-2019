package com.cg.empapp.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// A Special component to run along ALL controllers
// If Any controller gets Unhandled Exception,
// This component would be invoked
@ControllerAdvice
public class MyExceptionMapper{
	
	// If exception occurred is "ApplicationException"
	// Then run this method
	@ExceptionHandler(value=ApplicationException.class)
	@ResponseBody
	protected ResponseEntity<String> handleError(ApplicationException ex,
			HttpServletRequest req ) {
		String message = ex.getMessage();
		System.out.println("Caught Exception "+message);
		String url = req.getRequestURI().toString();
		System.out.println("Error at "+url);
		return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
	}
}
