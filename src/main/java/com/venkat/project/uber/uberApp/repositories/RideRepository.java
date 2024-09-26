package com.venkat.project.uber.uberApp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkat.project.uber.uberApp.entities.Driver;
import com.venkat.project.uber.uberApp.entities.Ride;
import com.venkat.project.uber.uberApp.entities.Rider;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {

	Page<Ride> findByRider(Rider rider, Pageable pageRequest);

	Page<Ride> findByDriver(Driver driver, Pageable pageRequest);
}
