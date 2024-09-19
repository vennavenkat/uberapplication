package com.venkat.project.uber.uberApp.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.venkat.project.uber.uberApp.entities.RideRequest;
import com.venkat.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.venkat.project.uber.uberApp.repositories.RideRequestRepository;
import com.venkat.project.uber.uberApp.services.RideRequestService;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not found with id: "+rideRequestId));
    }

    @Override
    public void update(RideRequest rideRequest) {
        rideRequestRepository.findById(rideRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not found with id: "+rideRequest.getId()));
        rideRequestRepository.save(rideRequest);
    }
}
