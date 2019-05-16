package com.cg.jpademo1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.jpademo1.entities.Movie;

@Repository
public interface MovieDAO
	extends JpaRepository<Movie, Integer>{

}
