package com.venkat.project.uber.uberApp.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.venkat.project.uber.uberApp.dto.DriverDto;
import com.venkat.project.uber.uberApp.dto.RideDto;
import com.venkat.project.uber.uberApp.dto.RideRequestDto;
import com.venkat.project.uber.uberApp.dto.RiderDto;
import com.venkat.project.uber.uberApp.entities.Rider;
import com.venkat.project.uber.uberApp.entities.User;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId, Integer rating);

    RiderDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
