package com.venkat.project.uber.uberApp.strategies;

import com.venkat.project.uber.uberApp.entities.Payment;

public interface PaymentStrategy {
	
	 Double PLATFROM_COMISSION = 0.3;
	
	void processPayment(Payment payment);

}
