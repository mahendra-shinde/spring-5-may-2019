package com.cg.jpademo1.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.jpademo1.config.AppConfig;
import com.cg.jpademo1.entities.Movie;
import com.cg.jpademo1.services.MovieService;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		MovieService service = context.getBean(MovieService.class);
		System.out.println("Creating new movie");
		Movie m1 = new Movie();
		m1.setBudget(12500000D);
		m1.setDirector("Karan Johar");
		m1.setGenre("Comedy");
		m1.setTitle("SOTY2");
		m1.setId(10023);
		
		service.save(m1);
		System.out.println("Movie details "+m1.getTitle()+" by "+m1.getDirector());
		
		Movie m2 = service.findById(10023);
		System.out.println("Movie found: "+m2.getTitle()+" budget: "+m2.getBudget());
		
	}

}
