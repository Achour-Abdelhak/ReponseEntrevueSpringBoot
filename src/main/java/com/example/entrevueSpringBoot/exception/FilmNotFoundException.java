package com.example.entrevueSpringBoot.exception;

public class FilmNotFoundException extends RuntimeException{
    public FilmNotFoundException(String message) {
        super(message);
    }
}
