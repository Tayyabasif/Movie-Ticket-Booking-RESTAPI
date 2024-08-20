package com.movieticketbooking.webapp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Movie")
public class Movie{
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@OneToMany(mappedBy="movie", cascade=CascadeType.ALL)
	private List<Theater> theater;
	
	
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
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
