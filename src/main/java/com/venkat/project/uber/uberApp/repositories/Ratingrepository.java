package com.venkat.project.uber.uberApp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkat.project.uber.uberApp.entities.Driver;
import com.venkat.project.uber.uberApp.entities.Rating;
import com.venkat.project.uber.uberApp.entities.Ride;
import com.venkat.project.uber.uberApp.entities.Rider;

@Repository
public interface Ratingrepository extends JpaRepository<Rating, Long> {
	
	List<Rating> findByRider(Rider rider);
	List<Rating> findByDriver(Driver driver);
	
	Optional<Rating> findByRide(Ride ride);

}
