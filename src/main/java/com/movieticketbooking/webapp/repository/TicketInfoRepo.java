package com.movieticketbooking.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieticketbooking.webapp.entity.TicketInfo;

public interface TicketInfoRepo extends JpaRepository<TicketInfo,Integer> {

}
