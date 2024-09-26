package com.venkat.project.uber.uberApp.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.venkat.project.uber.uberApp.dto.DriverDto;
import com.venkat.project.uber.uberApp.dto.RideDto;
import com.venkat.project.uber.uberApp.dto.RiderDto;
import com.venkat.project.uber.uberApp.entities.Driver;

public interface DriverService {

    RideDto acceptRide(Long rideRequestId);

    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId, String otp);

    RideDto endRide(Long rideId);

    RiderDto rateRider(Long rideId, Integer rating);

    DriverDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Driver getCurrentDriver();
    
    Driver updateDriverAvailability(Driver driver, boolean available);
}
