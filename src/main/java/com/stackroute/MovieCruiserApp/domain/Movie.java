package com.stackroute.MovieCruiserApp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    int imdbId;
    String movieTitle;
    int yearOfRelease;
    double rating;
    String comment;
    String posterUrl;

    public Movie() {
    }

    public Movie(int imdbId, String movieTitle, int yearOfRelease, String comment,double rating, String posterUrl) {
        this.imdbId = imdbId;
        this.movieTitle= movieTitle;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.comment = comment;
        this.posterUrl =posterUrl;
    }

    public int getImdbId() {
        return imdbId;
    }

    public void setImdbId(int imdbId) {
        this.imdbId = imdbId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
