package com.cg.bootdemo2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bootdemo2.entities.Movie;

@Repository
public interface MovieDAO
	extends JpaRepository<Movie, Integer>{

}
