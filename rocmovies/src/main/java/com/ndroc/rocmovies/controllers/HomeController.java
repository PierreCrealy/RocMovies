package com.ndroc.rocmovies.controllers;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ndroc.rocmovies.entities.Movie;
import com.ndroc.rocmovies.entities.MovieStyles;
import com.ndroc.rocmovies.services.IMovieService;


@Controller
public class HomeController {

    @Autowired
    private IMovieService movieService;

    @Value("${spring.profiles.active}")
    private String profile;
    
    @RequestMapping(value={"", "/", "home"})
    public String displayHomePage(Model model) {

        List<Movie> movies = movieService.getListMovies();
        List<MovieStyles> styles = Arrays.asList(MovieStyles.class.getEnumConstants());

        model.addAttribute("movies", movies);
        model.addAttribute("styles", styles);

        return "index.html";
    }
  
}
