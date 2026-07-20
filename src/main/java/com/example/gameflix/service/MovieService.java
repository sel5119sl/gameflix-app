package com.example.gameflix.service;

import com.example.gameflix.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovieById(Long id);

    Movie saveMovie(Movie movie);

}