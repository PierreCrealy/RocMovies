package com.ndroc.rocmovies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ndroc.rocmovies.entities.Movie;

@Service
public interface IMovieService {

    List<Movie> getListMovies();

    Optional<Movie> getMovieById(long id);

    void addMovie(Movie movie);
}
