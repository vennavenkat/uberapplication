package com.venkat.project.uber.uberApp.services;

import com.venkat.project.uber.uberApp.entities.Payment;
import com.venkat.project.uber.uberApp.entities.Ride;

public interface PaymentService {
	
	void processPayment(Payment payment);
	
	Payment createNewPayment(Ride ride);

}
