package com.ndroc.rocmovies.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ndroc.rocmovies.entities.Movie;
import com.ndroc.rocmovies.entities.MovieStyles;
import com.ndroc.rocmovies.services.IMovieService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("movie/json")
public class MovieJsonController {

    @Autowired
    private IMovieService movieService;


    @GetMapping()
    public List<Movie> getListMovies(@RequestParam(name = "style") Optional<MovieStyles> movieStyle) {

        List<Movie> movies = movieService.getListMovies();
        List<MovieStyles> styles = Arrays.asList(MovieStyles.class.getEnumConstants());

        if(movieStyle.isPresent()){
            //movies.removeIf(m->m.getStyle() != movieStyle.get());
            movies = movies.stream().filter(m -> m.getStyle().equals(movieStyle.get())).collect(Collectors.toList());
        }

        return movies;
    }
    


    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") Long movieId){

        Movie movie = movieService.getMovieById(movieId).get();

        return movie;
    }
    
    

}
