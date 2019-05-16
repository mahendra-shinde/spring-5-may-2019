package com.cg.jpademo1.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.jpademo1.entities.Movie;


@Repository //DAO Annotation
public class MovieDAOImpl implements MovieDAO {

	@PersistenceContext  // Injecting ready to use EntityManager
	private EntityManager em;
	
	// DAO Save without TRANSACTION !!
	public void save(Movie movie) {
		em.persist(movie);
	}

	public Movie findById(Integer id) {
		return em.find(Movie.class, id);
	}

}
