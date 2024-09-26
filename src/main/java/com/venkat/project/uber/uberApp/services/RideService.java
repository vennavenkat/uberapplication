package com.venkat.project.uber.uberApp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.venkat.project.uber.uberApp.dto.RideRequestDto;
import com.venkat.project.uber.uberApp.entities.Driver;
import com.venkat.project.uber.uberApp.entities.Ride;
import com.venkat.project.uber.uberApp.entities.RideRequest;
import com.venkat.project.uber.uberApp.entities.Rider;
import com.venkat.project.uber.uberApp.entities.enums.RideStatus;

public interface RideService {

    Ride getRideById(Long rideId);

    //already implemented in riderserviceIMpl
//    void matchWithDrivers(RideRequestDto rideRequestDto);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);
}
