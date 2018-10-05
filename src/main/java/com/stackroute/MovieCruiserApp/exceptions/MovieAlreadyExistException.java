package com.stackroute.MovieCruiserApp.exceptions;

public class MovieAlreadyExistException extends Exception {
    private String message;

    public MovieAlreadyExistException() {
    }

    public MovieAlreadyExistException(String message) {
        this.message = message;
    }
}
