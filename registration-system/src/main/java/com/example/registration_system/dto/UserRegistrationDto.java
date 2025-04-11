package com.example.registration_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegistrationDto {
    @NotBlank(message = "Username is Required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 Characters")
    private String username;

    @NotBlank(message = "Email is Required")
    @Email(message = "Email Should be Valid")
    private String email;

    @NotBlank(message = "Password is Required")
    @Size(min = 6, max = 30, message = "Password must be between 6 and 30 Characters")
    private String password;

    // Manual Getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Manual Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}