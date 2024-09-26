package com.venkat.project.uber.uberApp.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.dto.WalletTransactionDto;
import com.venkat.project.uber.uberApp.entities.WalletTransaction;
import com.venkat.project.uber.uberApp.repositories.WalletTransactionRepository;
import com.venkat.project.uber.uberApp.services.WalletTransactionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {
	
	private final WalletTransactionRepository walletTransactionRepository;
	private final ModelMapper modelMapper;
	
	
	@Override
	public void createNewWalletTransaction(WalletTransaction walletTransaction) {
		walletTransactionRepository.save(walletTransaction);
		
	}
	
	

}
