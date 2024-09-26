package com.venkat.project.uber.uberApp.strategies.impl;

import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.entities.Driver;
import com.venkat.project.uber.uberApp.entities.Payment;
import com.venkat.project.uber.uberApp.entities.Wallet;
import com.venkat.project.uber.uberApp.entities.enums.PaymentStatus;
import com.venkat.project.uber.uberApp.entities.enums.TransactionMethod;
import com.venkat.project.uber.uberApp.repositories.PaymentRepository;
import com.venkat.project.uber.uberApp.services.PaymentService;
import com.venkat.project.uber.uberApp.services.WalletService;
import com.venkat.project.uber.uberApp.strategies.PaymentStrategy;

import lombok.RequiredArgsConstructor;

//Rider ->100
//Driver ->70 Deduct 30Rs from Driver's wallet

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy{
	
	private final WalletService walletService;
//	private final PaymentService paymentService;
	private final PaymentRepository paymentRepository;
	
	@Override
	public void processPayment(Payment payment) {
		Driver driver = payment.getRide().getDriver();
		
		
		double platformComission = payment.getAmount() * PLATFROM_COMISSION;
		
		walletService.deductmoneyFromWallet(driver.getUser(), platformComission, null, 
				payment.getRide(), TransactionMethod.RIDE);
//		paymentService.updatePaymentStatus(payment, PaymentStatus.CONFIRMED);
		payment.setPaymentStatus(PaymentStatus.CONFIRMED);
		paymentRepository.save(payment);
		
		
	}

}
