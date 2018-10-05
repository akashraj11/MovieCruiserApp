package com.stackroute.MovieCruiserApp.services;

import com.stackroute.MovieCruiserApp.domain.Movie;
import com.stackroute.MovieCruiserApp.exceptions.MovieAlreadyExistException;
import com.stackroute.MovieCruiserApp.exceptions.MovieNotFoundException;

import java.util.List;

public interface MovieServices {
    public Movie addMovie(Movie movie) throws MovieAlreadyExistException;
    public List<Movie> getAllMovie();
    public Movie deleteMovie(int imdbId);
    public Movie getMovieById(int imdbId) throws MovieNotFoundException;
    public Movie getMovieByName(String movieTitle) throws MovieNotFoundException;
    public Movie updateMovie(String movieId, String comment) ;
}
