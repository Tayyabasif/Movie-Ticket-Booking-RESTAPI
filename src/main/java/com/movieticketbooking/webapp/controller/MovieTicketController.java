package com.movieticketbooking.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketbooking.webapp.dto.MovieTicketAcknowledgement;
import com.movieticketbooking.webapp.dto.MovieTicketRequest;
import com.movieticketbooking.webapp.entity.Movie;
import com.movieticketbooking.webapp.entity.Theater;
import com.movieticketbooking.webapp.service.MovieTicketService;

@RestController
public class MovieTicketController {
	

	@Autowired
	MovieTicketService service;
	
	@PostMapping("/bookMovieTicket")
	public MovieTicketAcknowledgement bookTicket(@RequestBody MovieTicketRequest request) {
		return service.bookMovieTicket(request);
	}
	
	@GetMapping("/theaterList/{movie}/{location}")
	public List<Theater> showTheater(@PathVariable String movie,@PathVariable String location) {
		return service.theaterList(movie,location);
	}
	
	@PostMapping("/addTheater/{movieId}")
	public Theater addTheaterControl(@RequestBody Theater theater,@PathVariable long movieId) {
		return service.addTheater(theater,movieId);
	}
	
	@PutMapping("/updateTheater")
	public Theater updateTheater(@RequestBody Theater theater) {
		return service.editTheater(theater);
	}
	
	@GetMapping("/theaterList")
	public List<Theater> showTheaters(){
		return service.allTheaterList();
	}
	
	@DeleteMapping("/deleteTheater/{id}")
	public String deleteTheater(@PathVariable Long id) {
		return service.removeTheter(id);
	}
	
	@PostMapping("/addMovie")
	public Movie addMovieControl(@RequestBody Movie movie) {
		
		return service.addMovie(movie);
	}
	
	@PutMapping("/updateMapping")
	public Movie updateMovie(@RequestBody Movie movie) {
		
		return service.addMovie(movie);
	}
	
	@GetMapping("/movieList")
	public List<Movie> movieList(){
		
		return service.allMovieList();
	}
	
	@DeleteMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable long id) {
		return service.removeMovie(id);
	}
	
	
}
