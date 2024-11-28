package com.ndroc.rocmovies.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import com.ndroc.rocmovies.entities.Movie;
import com.ndroc.rocmovies.entities.MovieStyles;
import com.ndroc.rocmovies.services.IMovieService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private IMovieService movieService;


    @GetMapping()
    public String getListMovies(@RequestParam(name = "style") Optional<MovieStyles> movieStyle, Model mode, Model model) {

        List<Movie> movies = movieService.getListMovies();
        List<MovieStyles> styles = Arrays.asList(MovieStyles.class.getEnumConstants());

        if(movieStyle.isPresent()){
            //movies.removeIf(m->m.getStyle() != movieStyle.get());
            movies = movies.stream().filter(m -> m.getStyle().equals(movieStyle.get())).collect(Collectors.toList());

            System.out.println(movies);
        }

        model.addAttribute("movies", movies);
        model.addAttribute("styles", styles);

        return "movie-list.html";
    }
    
    
    @GetMapping("/{id}")
    @RequestMapping(value={"/{id}"})
    public String getMovieById(@PathVariable("id") Long movieId, Model model){

        Optional<Movie> movie = movieService.getMovieById(movieId);

        if(movie.isPresent()){

            model.addAttribute("movie", movie.get());

            return "movie-single.html";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le film n'a pas été trouver");
        }
       
    }


    
    @GetMapping("/adding")
    public String getListMovies(Model mode, Model model) {

        List<MovieStyles> styles = Arrays.asList(MovieStyles.class.getEnumConstants());
        model.addAttribute("styles", styles);

        return "movie-add.html";
    }




    
    @PostMapping
    public String postMethodName(
        @Valid
        @RequestParam Integer idMovie,
        @RequestParam String title,
        @RequestParam MovieStyles style,
        @RequestParam Integer productionYear,
        @RequestParam String ref,
        @RequestParam String imageSrc,
        Model model
        ) {

        Movie movie = new Movie(idMovie, title, style, productionYear,ref, imageSrc);

        
        
       movieService.addMovie(movie);

       List<Movie> movies = movieService.getListMovies();
       List<MovieStyles> styles = Arrays.asList(MovieStyles.class.getEnumConstants());

       model.addAttribute("movies", movies);
       model.addAttribute("styles", styles);

       return "movie-list.html";
    }
    
    
    

}
