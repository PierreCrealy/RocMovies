package com.ndroc.rocmovies.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.ndroc.rocmovies.entities.Movie;
import com.ndroc.rocmovies.entities.MovieStyles;

@ExtendWith(MockitoExtension.class)
public class AdvancedMovieServiceTest {


    @Mock
    private MovieService1 movieService1;

    @InjectMocks
    private AdvancedMovieService advancedMovieService;


    @Test
    void testGetActionMovies() {

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1,"Cloud Atlas1",MovieStyles.ACTION,2012, "FR-987654", "https://fr.web.img5.acsta.net/medias/nmedia/18/92/29/61/20471737.jpg"));
        movies.add(new Movie(2,"Shutter Island1",MovieStyles.ACTION,2010, "FR-987654", "https://fr.web.img2.acsta.net/c_310_420/medias/nmedia/18/69/96/84/19151192.jpg"));
        movies.add(new Movie(3,"Interstellar1",MovieStyles.SF,2018, "FR-987654", "https://fr.web.img5.acsta.net/c_310_420/pictures/14/09/24/12/08/158828.jpg"));
        movies.add(new Movie(4,"Pulp Fiction1",MovieStyles.ACTION,2001, "FR-987654", "https://fr.web.img2.acsta.net/c_310_420/medias/nmedia/18/36/02/52/18846059.jpg"));
    
        when(advancedMovieService.getActionMovies()).thenReturn(movies);

        List<Movie> result = advancedMovieService.getActionMovies();

        assertTrue(result.size() == 3, "Ce résultat devrait être égal à 3");

    }


    @Test
    void TestGetMoviesBetween() {

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1,"Cloud Atlas1",MovieStyles.ACTION,2012, "FR-987654", "https://fr.web.img5.acsta.net/medias/nmedia/18/92/29/61/20471737.jpg"));
        movies.add(new Movie(2,"Shutter Island1",MovieStyles.ACTION,2010, "FR-987654", "https://fr.web.img2.acsta.net/c_310_420/medias/nmedia/18/69/96/84/19151192.jpg"));
        movies.add(new Movie(3,"Interstellar1",MovieStyles.SF,2018, "FR-987654", "https://fr.web.img5.acsta.net/c_310_420/pictures/14/09/24/12/08/158828.jpg"));
        movies.add(new Movie(4,"Pulp Fiction1",MovieStyles.ACTION,2001, "FR-987654", "https://fr.web.img2.acsta.net/c_310_420/medias/nmedia/18/36/02/52/18846059.jpg"));
    
        when(advancedMovieService.getMoviesBetween(2000, 2019)).thenReturn(movies);

        List<Movie> result = advancedMovieService.getMoviesBetween(2000, 2019);

        assertTrue(result.size() == 4, "Ce résultat devrait être égal à 1");

    }

}
