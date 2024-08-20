package com.movieticketbooking.webapp.entity;

//import org.hibernate.annotations.NotFound;
//import org.hibernate.annotations.NotFoundAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Theater")
public class Theater {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String location;
	
	@ManyToOne
	private Movie movie;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Theater [id=" + id + ", name=" + name + ", location=" + location + ", movie=" + movie + "]";
	}
	
	
	
}

