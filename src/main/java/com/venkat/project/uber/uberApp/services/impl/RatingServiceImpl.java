package com.venkat.project.uber.uberApp.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.dto.DriverDto;
import com.venkat.project.uber.uberApp.dto.RiderDto;
import com.venkat.project.uber.uberApp.entities.Driver;
import com.venkat.project.uber.uberApp.entities.Rating;
import com.venkat.project.uber.uberApp.entities.Ride;
import com.venkat.project.uber.uberApp.entities.Rider;
import com.venkat.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.venkat.project.uber.uberApp.exceptions.RuntimeConflictException;
import com.venkat.project.uber.uberApp.repositories.DriverRepository;
import com.venkat.project.uber.uberApp.repositories.Ratingrepository;
import com.venkat.project.uber.uberApp.repositories.RiderRepository;
import com.venkat.project.uber.uberApp.services.RatingService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService{
	
	private final Ratingrepository ratingrepository;
	private final DriverRepository driverRepository;
	private final RiderRepository riderRepository;
	private final ModelMapper modelMapper;
	
	@Override
	public DriverDto rateDriver(Ride ride, Integer rating) {
		Driver driver = ride.getDriver();
		Rating ratingObj = ratingrepository.findByRide(ride)
				.orElseThrow(() -> new ResourceNotFoundException("Rating not found for ride with id: "+ride.getId()));
		if(ratingObj.getDriverrating()!= null)
			throw new RuntimeConflictException("Driver has already been rated, cannot rate again");
		
		ratingObj.setDriverrating(rating);
		
		ratingrepository.save(ratingObj);
		
		Double newRating = ratingrepository.findByDriver(driver)
				.stream()
				.mapToDouble(Rating::getDriverrating)
				.average().orElse(0.0);
		driver.setRating(newRating);
		Driver savedDriver = driverRepository.save(driver);
		
		return modelMapper.map(savedDriver, DriverDto.class);
		
	}

	@Override
	public RiderDto rateRider(Ride ride, Integer rating) {
		Rider rider = ride.getRider();
		Rating ratingObj = ratingrepository.findByRide(ride)
				.orElseThrow(() -> new ResourceNotFoundException("Rating not found for ride with id: "+ride.getId()));
		if(ratingObj.getRiderRating()!= null)
			throw new RuntimeConflictException("Driver has already been rated, cannot rate again");
		
		ratingObj.setRiderRating(rating);
		
		ratingrepository.save(ratingObj);
		
		Double newRating = ratingrepository.findByRider(rider)
				.stream()
				.mapToDouble(Rating::getRiderRating)
				.average().orElse(0.0);
		rider.setRating(newRating);
		Rider savedRider = riderRepository.save(rider);
		
		return modelMapper.map(savedRider, RiderDto.class);
	}

	@Override
	public void createNewRating(Ride ride) {
		Rating rating = Rating.builder()
				.rider(ride.getRider())
				.driver(ride.getDriver())
				.ride(ride)
				.build();
		
		ratingrepository.save(rating);
	}

}
