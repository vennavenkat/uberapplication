package com.venkat.project.uber.uberApp.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.venkat.project.uber.uberApp.entities.enums.TransactionMethod;
import com.venkat.project.uber.uberApp.entities.enums.TransactionType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WalletTransactionDto {
	
	private Long id;
	
	private Double amount;
	
	private TransactionType transactionType;
	
	private TransactionMethod transactionMethod;
	
	private RideDto ride;
	
	private String transactionId;
	
	private WalletDto wallet;
	
	@CreationTimestamp
	private LocalDateTime timeStamp;

}
