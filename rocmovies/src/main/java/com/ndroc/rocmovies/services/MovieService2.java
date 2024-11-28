package com.ndroc.rocmovies.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ndroc.rocmovies.entities.Movie;
import com.ndroc.rocmovies.entities.MovieStyles;

@Service
@Profile("PreProd")
public class MovieService2 implements IMovieService{


    /**
     * Fournit une liste de films 'en dur' 
     * en attendant de pouvoir utiliser une base de données 
     * @return
     */
    private static List<Movie> getDefaultList()
    {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1,"Cloud Atlas2",MovieStyles.SF,2012, "FR-987654", "https://fr.web.img5.acsta.net/medias/nmedia/18/92/29/61/20471737.jpg"));
        movies.add(new Movie(2,"Shutter Island2",MovieStyles.THRILLER,2010, "FR-987654", "https://fr.web.img2.acsta.net/c_310_420/medias/nmedia/18/69/96/84/19151192.jpg"));
        movies.add(new Movie(3,"Interstellar2",MovieStyles.SF,2018, "FR-987654", "https://fr.web.img5.acsta.net/c_310_420/pictures/14/09/24/12/08/158828.jpg"));
        movies.add(new Movie(4,"Pulp Fiction2",MovieStyles.ACTION,2001, "FR-987654", "https://fr.web.img2.acsta.net/c_310_420/medias/nmedia/18/36/02/52/18846059.jpg"));
        movies.add(new Movie(5,"Mulholland Drive2",MovieStyles.THRILLER,2001, "FR-987654", "https://fr.web.img3.acsta.net/c_310_420/pictures/21/12/08/16/03/5133751.jpg"));
        
        return movies;
    }
    private List<Movie> movieList;

    /** 
     * Liste complète de tous les films
     */
    @Override
    public List<Movie> getListMovies(){
        if (movieList == null)
        {
            movieList = getDefaultList();
        }
        return movieList;
    }

    @Override
    public Optional<Movie> getMovieById(long id){
        return getListMovies().stream().filter(m -> m.getIdMovie()==id).findFirst();
    }


    public MovieService2(){
        System.out.println("Création du service MovieService2");
    }

    
    @Override
    public void addMovie(Movie movie) {

        getListMovies().add(movie);
    }
    
}
