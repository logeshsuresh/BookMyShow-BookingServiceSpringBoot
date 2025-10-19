package com.logesh.bookmyshow.services;

import com.logesh.bookmyshow.entities.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAllMovies();
    Movie findMovieById(Long movieId);
}
