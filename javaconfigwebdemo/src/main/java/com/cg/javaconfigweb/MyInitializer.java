package com.cg.javaconfigweb;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyInitializer 
	implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context
			= new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);
		
		AnnotationConfigWebApplicationContext dispatcherContext =
		        new AnnotationConfigWebApplicationContext();
		      dispatcherContext.register(DispatcherConfig.class);

		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher =
		     servletContext.addServlet("dispatcher", 
		    		 new DispatcherServlet(dispatcherContext));
		     dispatcher.setLoadOnStartup(1);
		     dispatcher.addMapping("/");

	}

	
}
