package com.venkat.project.uber.uberApp.services.impl;

import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.entities.Payment;
import com.venkat.project.uber.uberApp.entities.Ride;
import com.venkat.project.uber.uberApp.repositories.PaymentRepository;
import com.venkat.project.uber.uberApp.services.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
	
	private final PaymentRepository paymentRepository;
	
	@Override
	public void processPayment(Payment payment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Payment createNewPayment(Ride ride) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
