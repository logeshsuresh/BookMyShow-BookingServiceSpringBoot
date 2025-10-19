package com.logesh.bookmyshow.services.impl;

import com.logesh.bookmyshow.entities.Movie;
import com.logesh.bookmyshow.repositories.MovieRepository;
import com.logesh.bookmyshow.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAllMovies() {
        return this.movieRepository.findAll();
    }

    @Override
    public Movie findMovieById(Long movieId) {
        return this.movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException(String.format("MovieId: {} not found", movieId)));
    }

}
