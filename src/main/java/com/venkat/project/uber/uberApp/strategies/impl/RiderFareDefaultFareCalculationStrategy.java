package com.venkat.project.uber.uberApp.strategies.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.entities.RideRequest;
import com.venkat.project.uber.uberApp.services.DistanceService;
import com.venkat.project.uber.uberApp.strategies.RideFareCalculationStrategy;

@RequiredArgsConstructor
@Service
public class RiderFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),
                rideRequest.getDropOffLocation());
        return distance*RIDE_FARE_MULTIPLIER;
    }
}
