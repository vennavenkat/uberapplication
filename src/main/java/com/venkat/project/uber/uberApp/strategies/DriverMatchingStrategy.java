package com.venkat.project.uber.uberApp.strategies;

import java.util.List;

import com.venkat.project.uber.uberApp.entities.Driver;
import com.venkat.project.uber.uberApp.entities.RideRequest;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
