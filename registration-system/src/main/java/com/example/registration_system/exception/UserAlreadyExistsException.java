package com.example.registration_system.exception;

public class UserAlreadyExistsException extends RuntimeException
{
    public UserAlreadyExistsException( String message)
    {
        super(message);
    }
}