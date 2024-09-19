package com.venkat.project.uber.uberApp.dto;

import lombok.Data;
import org.locationtech.jts.geom.Point;

import com.venkat.project.uber.uberApp.entities.enums.PaymentMethod;
import com.venkat.project.uber.uberApp.entities.enums.RideStatus;

import java.time.LocalDateTime;

@Data
public class RideDto {

    private Long id;
    private PointDto pickupLocation;
    private PointDto dropOffLocation;

    private LocalDateTime createdTime;
    private RiderDto rider;
    private DriverDto driver;
    private PaymentMethod paymentMethod;

    private RideStatus rideStatus;

    private String otp;

    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
