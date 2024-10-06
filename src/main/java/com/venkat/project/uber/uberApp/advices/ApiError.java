package com.venkat.project.uber.uberApp.advices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> subErrors;

}
