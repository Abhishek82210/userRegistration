package com.example.registration_system.controller;

import com.example.registration_system.dto.ApiResponse;
import com.example.registration_system.dto.UserRegistrationDto;
import com.example.registration_system.exception.UserAlreadyExistsException;
import com.example.registration_system.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import com.example.registration_system.exception.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(
        origins = "http://localhost:3000",
        allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.OPTIONS},
        allowCredentials = "true"
)
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody UserRegistrationDto registrationDto,
                                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());
            throw new ValidationException(errors);
        }

        try {
            userService.registerUser(registrationDto);
            return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, e.getMessage()));
        }
    }
}