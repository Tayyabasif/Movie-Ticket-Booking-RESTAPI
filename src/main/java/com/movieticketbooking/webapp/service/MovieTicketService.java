package com.movieticketbooking.webapp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticketbooking.webapp.dto.MovieTicketAcknowledgement;
import com.movieticketbooking.webapp.dto.MovieTicketRequest;
import com.movieticketbooking.webapp.entity.Movie;
import com.movieticketbooking.webapp.entity.PaymentInfo;
import com.movieticketbooking.webapp.entity.Theater;
import com.movieticketbooking.webapp.entity.TicketInfo;
import com.movieticketbooking.webapp.repository.MovieRepo;
import com.movieticketbooking.webapp.repository.PaymentInfoRepo;
import com.movieticketbooking.webapp.repository.TheaterRepo;
import com.movieticketbooking.webapp.repository.TicketInfoRepo;
import com.movieticketbooking.webapp.utility.ValidatePaymentInfo;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class MovieTicketService {
	
	@Autowired
	TicketInfoRepo ticketRepo;
	
	@Autowired
	PaymentInfoRepo paymentRepo;
	
	@Autowired
	TheaterRepo theaterRepo;
	
	@Autowired
	MovieRepo movieRepo;
	
	@Transactional
	public MovieTicketAcknowledgement bookMovieTicket(MovieTicketRequest request) {
		TicketInfo ticketInfo = request.getTicketInfo();
		ticketRepo.save(ticketInfo);
		
		PaymentInfo paymentInfo = request.getPaymentInfo();	  
		ValidatePaymentInfo.validateCreditLimit(paymentInfo.getAccountNo(),ticketInfo.getTicketPrice());
		
		paymentInfo.setTicketId(ticketInfo.getId());
		paymentInfo.setAmount(ticketInfo.getTicketPrice());
		
		paymentRepo.save(paymentInfo);
		
		return new MovieTicketAcknowledgement("SUCCESS",ticketInfo.getTicketPrice(),UUID.randomUUID().toString().split("-")[0],ticketInfo);
	}
	
	public List<Theater> theaterList(String movie,String location) {
		long movieId = movieRepo.getIdByMovie(movie);
		return theaterRepo.findByMovieIdAndLocation(movieId,location);
	}
	
	public Theater addTheater(Theater theater,long movieId) {
		
		    Movie movie = movieRepo.findById(movieId).orElseThrow(() -> new EntityNotFoundException("Parent not found"));
		    theater.setMovie(movie);
		    theaterRepo.save(theater);
		
		return theater;
	}
	
	public Theater editTheater(Theater theater) {
		theaterRepo.save(theater);
		return theater;
	}
	
	public List<Theater> allTheaterList(){
		return theaterRepo.findAll();
	}
	
	public String removeTheter(long id) {
		
		theaterRepo.deleteById(id);
		return "Deleted";
		
	}
	
	public Movie addMovie(Movie movie) {
		
		movieRepo.save(movie);
		return movie;
	}
	
	public List<Movie> allMovieList(){
		
		return movieRepo.findAll();
	}
	
	public String removeMovie(long id) {
		
		movieRepo.deleteById(id);
		return "Deleted";
	}
	
}
