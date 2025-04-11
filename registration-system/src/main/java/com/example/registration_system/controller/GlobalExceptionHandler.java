package com.example.registration_system.controller;

import com.example.registration_system.dto.ApiResponse;
import com.example.registration_system.exception.UserAlreadyExistsException;
import com.example.registration_system.exception.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse> handleValidationException(ValidationException ex) {
        return ResponseEntity.badRequest()
                .body(new ApiResponse(false, "Validation failed", ex.getErrors()));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiResponse> handleUserExistsException(UserAlreadyExistsException ex) {
        return ResponseEntity.badRequest()
                .body(new ApiResponse(false, ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleAllExceptions(Exception ex) {
        return ResponseEntity.internalServerError()
                .body(new ApiResponse(false, "Server Error: " + ex.getMessage()));
    }
}