package com.cg.jpademo1.entities;

import javax.persistence.*;

@Entity @Table(name="movies")
public class Movie {
	
	@Id private Integer id;
	
	@Column(length=40)
	private String title;
	
	@Column(length=40)
	private String director;
	
	private Double budget;
	
	@Column(length=10)
	private String genre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
