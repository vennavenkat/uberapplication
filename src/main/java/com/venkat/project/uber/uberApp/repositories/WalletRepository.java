package com.venkat.project.uber.uberApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkat.project.uber.uberApp.entities.User;
import com.venkat.project.uber.uberApp.entities.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

	Optional<Wallet> findByUser(User user);

}
