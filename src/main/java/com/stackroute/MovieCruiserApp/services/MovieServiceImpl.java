package com.stackroute.MovieCruiserApp.services;

import com.stackroute.MovieCruiserApp.domain.Movie;
import com.stackroute.MovieCruiserApp.exceptions.MovieAlreadyExistException;
import com.stackroute.MovieCruiserApp.exceptions.MovieNotFoundException;
import com.stackroute.MovieCruiserApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieServices{
    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(Movie movie) throws MovieAlreadyExistException {
        List<Movie> movieList = movieRepository.findAll();
        for(Movie movie1: movieList) {
            if ((movie1.getMovieTitle()).equals(movie.getMovieTitle())) {
                throw new MovieAlreadyExistException("Movie Already Exists");
            }
        }
        Movie savedMovie = movieRepository.save(movie);
        if(savedMovie == null)
        {
            throw new MovieAlreadyExistException("Movie Already Exists");
        }
        return savedMovie;
}

    public List<Movie> getAllMovie(){
        return (List<Movie>)movieRepository.findAll();
    }

    public Movie deleteMovie(int imdbId) {
        if(getMovieById(imdbId)==null) {
            return null;
        }
        else {
            Movie deletedMovie = getMovieById(imdbId);
            movieRepository.delete(deletedMovie);
            return deletedMovie;
        }
    }

    public Movie getMovieById(int imdbId) {
            return movieRepository.findById(imdbId).get();
    }

    public Movie getMovieByName(String movieTitle) throws MovieNotFoundException {
        List<Movie> movieList = movieRepository.findAll();
        for(Movie movie: movieList){
            if((movie.getMovieTitle()).equals(movieTitle)){
                return movie;
            }
            else{
                throw new MovieNotFoundException("Movie Not Found");
            }
        }
        return null;
    }

    public Movie updateMovie(String imdbId,String comment){
        int Id = Integer.parseInt(imdbId);
        if(getMovieById(Id)==null) {
            return null;
        }
        else {
            Movie updatedMovie = getMovieById(Id);
            updatedMovie.setComment(comment.trim());
            movieRepository.save(updatedMovie);
            return updatedMovie;
        }
    }


}
