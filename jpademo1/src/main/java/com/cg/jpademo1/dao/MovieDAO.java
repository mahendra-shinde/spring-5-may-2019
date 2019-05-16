package com.cg.jpademo1.dao;

import com.cg.jpademo1.entities.Movie;

public interface MovieDAO {

	void save(Movie movie);
	Movie findById(Integer id);
}
