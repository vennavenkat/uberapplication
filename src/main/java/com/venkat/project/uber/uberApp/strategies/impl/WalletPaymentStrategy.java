package com.venkat.project.uber.uberApp.strategies.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venkat.project.uber.uberApp.entities.Driver;
import com.venkat.project.uber.uberApp.entities.Payment;
import com.venkat.project.uber.uberApp.entities.Rider;
import com.venkat.project.uber.uberApp.entities.enums.PaymentStatus;
import com.venkat.project.uber.uberApp.entities.enums.TransactionMethod;
import com.venkat.project.uber.uberApp.repositories.PaymentRepository;
import com.venkat.project.uber.uberApp.services.PaymentService;
import com.venkat.project.uber.uberApp.services.WalletService;
import com.venkat.project.uber.uberApp.strategies.PaymentStrategy;

import lombok.RequiredArgsConstructor;

//Rider has 232, Driver had 500
//Ride cost is 100, commission = 30
//Rider ->232-100 = 132
//Driver -> 500 + (100-30) = 570

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {
	
	private final WalletService walletService;
	private final PaymentRepository paymentRepository;
	
	@Override
	public void processPayment(Payment payment) {
		Driver driver = payment.getRide().getDriver();
		Rider rider = payment.getRide().getRider();
		
		walletService.deductmoneyFromWallet(rider.getUser(), 
				payment.getAmount(), null, payment.getRide(), TransactionMethod.RIDE);
		
		double driversCut = payment.getAmount() * (1 - PLATFROM_COMISSION);
		
		walletService.addMoneyToWallet(driver.getUser(), driversCut, null, 
				payment.getRide(), TransactionMethod.RIDE);
		
//		paymentService.updatePaymentStatus(payment, PaymentStatus.CONFIRMED);
		payment.setPaymentStatus(PaymentStatus.CONFIRMED);
		paymentRepository.save(payment);
	}

}
