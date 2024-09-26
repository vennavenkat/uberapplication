package com.venkat.project.uber.uberApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkat.project.uber.uberApp.entities.WalletTransaction;

@Repository
public interface WalletTransactionRepository  extends JpaRepository<WalletTransaction, Long>{

}
