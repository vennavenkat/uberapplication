package com.venkat.project.uber.uberApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkat.project.uber.uberApp.entities.Rider;
import com.venkat.project.uber.uberApp.entities.User;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {

	Optional<Rider> findByUser(User user);
}
