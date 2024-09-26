package com.venkat.project.uber.uberApp.services;

import com.venkat.project.uber.uberApp.dto.WalletTransactionDto;
import com.venkat.project.uber.uberApp.entities.WalletTransaction;

public interface WalletTransactionService {
	
	void createNewWalletTransaction(WalletTransaction walletTransaction);

}
