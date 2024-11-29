package com.ndroc.rocmovies.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ndroc.rocmovies.entities.Movie;
import com.ndroc.rocmovies.entities.MovieStyles;

@ExtendWith(MockitoExtension.class)
public class MovieService1Test {

    @InjectMocks
    private MovieService1 movieService;

    @Test
    void testAddMovie() {

        Movie movie = new Movie(6, "Test", MovieStyles.DRAME, 2014,"FR-123456", "test"); 

        movieService.addMovie(movie);

        assertTrue(movieService.getListMovies().size() == 6, "Le nombre d'élément dans la list devrait avoir pris +1");

        movieService.getListMovies().removeLast();

        assertTrue(movieService.getListMovies().size() == 5, "Le nombre d'élément dans la list devrait avoir pris -1");

    }

}
