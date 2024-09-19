package com.venkat.project.uber.uberApp.strategies.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.entities.Driver;
import com.venkat.project.uber.uberApp.entities.RideRequest;
import com.venkat.project.uber.uberApp.repositories.DriverRepository;
import com.venkat.project.uber.uberApp.strategies.DriverMatchingStrategy;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearestDrivers(rideRequest.getPickupLocation());
    }
}
