package com.movieticketbooking.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movieticketbooking.webapp.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie,Long> {

	@Query("select id from Movie where name=?1")
	long getIdByMovie(String movie);
}
