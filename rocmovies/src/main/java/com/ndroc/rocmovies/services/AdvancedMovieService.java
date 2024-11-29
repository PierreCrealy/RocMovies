package com.ndroc.rocmovies.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ndroc.rocmovies.entities.Movie;
import com.ndroc.rocmovies.entities.MovieStyles;

@Service
@Profile("Advanced")
public class AdvancedMovieService implements IMovieService {

    /** Méthode spécifique */
    public List<Movie> getActionMovies() {
        List<Movie> list = movieService.getListMovies().stream().filter(p -> p.getStyle() == MovieStyles.ACTION)
                .collect(Collectors.toList());
        return list;
    }

    public List<Movie> getMoviesBetween(Integer yearA, Integer yearB){
        List<Movie> list = movieService.getListMovies().stream()
        .filter(p -> p.getProductionYear() >= yearA && p.getProductionYear() <= yearB)
        .collect(Collectors.toList());

        return list;
    }

    @Autowired
    private MovieService1 movieService;

    // Les méthodes suivantes sont simplement des appels au service "proxyfié"
    @Override
    public List<Movie> getListMovies() {
        return movieService.getListMovies();
    }

    @Override
    public Optional<Movie> getMovieById(long id) {

        return movieService.getMovieById(id);
    }


    @Override
    public void addMovie(Movie movie) {

        movieService.addMovie(movie);

    }

}
