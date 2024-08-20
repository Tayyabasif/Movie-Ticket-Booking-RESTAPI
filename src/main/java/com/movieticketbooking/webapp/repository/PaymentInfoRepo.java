package com.movieticketbooking.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieticketbooking.webapp.entity.PaymentInfo;

public interface PaymentInfoRepo extends JpaRepository<PaymentInfo,String>{

}
