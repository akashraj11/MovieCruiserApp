package com.stackroute.MovieCruiserApp.controller;

import com.stackroute.MovieCruiserApp.domain.Movie;
import com.stackroute.MovieCruiserApp.exceptions.MovieAlreadyExistException;
import com.stackroute.MovieCruiserApp.services.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movie")
public class MovieCruiserAppController {
   /* @Qualifier("userServicesImpl")
    private UserServices userService;
    */
    @Autowired
    @Qualifier("movieServiceImpl")
    private MovieServices movieService;

    /*
    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        ResponseEntity responseEntity;
        try {
            User savedUser = userService.addUser(user);
            responseEntity = new ResponseEntity<User>(savedUser, HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("users")
    public ResponseEntity<?> getAllUser(){
        List<User> userList;
        userList = userService.getAllUser();
        ResponseEntity responseEntity = new ResponseEntity<List<User>>(userList,HttpStatus.OK);
        return  responseEntity;
    }
    */
    @PostMapping()
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try {
            Movie savedMovie = movieService.addMovie(movie);
            responseEntity = new ResponseEntity<Movie>(savedMovie, HttpStatus.OK);
        }
        catch (MovieAlreadyExistException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping()
    public ResponseEntity<?> getAllMovie(){
        List<Movie> movieList;
        movieList = movieService.getAllMovie();
        ResponseEntity responseEntity = new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
        return  responseEntity;
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable int movieId){
        Movie deletedMovie = movieService.deleteMovie(movieId);
        ResponseEntity responseEntity = new ResponseEntity<Movie>(deletedMovie, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<?> updateMovie(@PathVariable String movieId,@RequestBody String comment){
        Movie updatedMovie = movieService.updateMovie(movieId,comment);
        ResponseEntity responseEntity = new ResponseEntity<Movie>(updatedMovie, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/{movieName}")
    public ResponseEntity<?> searcheMovie(@PathVariable String movieName){
        ResponseEntity responseEntity;
        try {
            Movie searchMovie = movieService.getMovieByName(movieName);
            responseEntity = new ResponseEntity<Movie>(searchMovie, HttpStatus.OK);
        }
        catch ( Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

}
