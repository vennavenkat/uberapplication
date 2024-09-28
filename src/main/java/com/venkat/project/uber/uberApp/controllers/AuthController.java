package com.venkat.project.uber.uberApp.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.project.uber.uberApp.dto.DriverDto;
import com.venkat.project.uber.uberApp.dto.SignupDto;
import com.venkat.project.uber.uberApp.dto.UserDto;
import com.venkat.project.uber.uberApp.dto.onbaoardDriverDto;
import com.venkat.project.uber.uberApp.services.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    ResponseEntity<UserDto> signUp(@RequestBody SignupDto signupDto) {
        return new ResponseEntity<>( authService.signup(signupDto), HttpStatus.CREATED);
    }
    
    @PostMapping("/onBoardNewDriver/{userId}")
    ResponseEntity<DriverDto> onBoardNewDriver(@PathVariable Long userId, @RequestBody onbaoardDriverDto onbaoardDriverDto){
    	return new ResponseEntity<>(authService.onboardNewDriver(userId, onbaoardDriverDto.getVehicleId()), HttpStatus.CREATED);
    }
    

}
