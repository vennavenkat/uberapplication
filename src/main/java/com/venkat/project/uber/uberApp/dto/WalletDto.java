package com.venkat.project.uber.uberApp.dto;

import java.util.List;

import lombok.Data;


@Data
public class WalletDto {

	private Long id;
	
	private UserDto user;
	
	private Double balance;
	
	private List<WalletTransactionDto> transactions;
	
}
