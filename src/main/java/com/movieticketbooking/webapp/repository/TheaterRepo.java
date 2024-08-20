package com.movieticketbooking.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movieticketbooking.webapp.entity.Movie;
import com.movieticketbooking.webapp.entity.Theater;

public interface TheaterRepo extends JpaRepository<Theater,Long> {

	@Query("from Theater t where t.movie.id=?1 and location=?2")
	List<Theater> findByMovieIdAndLocation(long movieId,String location);
}
