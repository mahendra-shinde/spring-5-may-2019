package com.cg.jpademo1.services;

import com.cg.jpademo1.entities.Movie;

public interface MovieService {

	void save(Movie m);
	Movie findById(Integer id);
}
