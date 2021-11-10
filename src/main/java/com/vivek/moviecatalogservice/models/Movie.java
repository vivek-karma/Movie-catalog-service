package com.vivek.moviecatalogservice.models;

public class Movie {
    private String movieName;
    private  String description;

    public Movie() {
    }

    public Movie(String movieName, String description) {
        this.movieName = movieName;
        this.description = description;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
