package com.cg.bootdemo2.services;

import com.cg.bootdemo2.entities.Movie;

public interface MovieService {

	void save(Movie m);
	Movie findById(Integer id);
}
