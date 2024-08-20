package com.movieticketbooking.webapp.utility;

import java.util.HashMap;
import java.util.Map;

import com.movieticketbooking.webapp.exception.InsufficientBalanceError;

public class ValidatePaymentInfo {

	private static Map<String,Double> paymentInfo = new HashMap<>();
	
	static {
		paymentInfo.put("acc1", 1000.00);
		paymentInfo.put("acc2", 500.00);
		paymentInfo.put("acc3", 2000.00);
	}
	public static boolean validateCreditLimit(String accNo,double paidAmount) {
		if(paidAmount>paymentInfo.get(accNo)) {
			throw new InsufficientBalanceError("Insufficient Balance");
		}
		else {
			return true;
		}
	}
}
