package com.ndroc.rocmovies.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Movie {

    public Movie(int idMovie, String title, MovieStyles style, int productionYear, String ref, String imageSrc) {
        this.idMovie = idMovie;
        this.title = title;
        this.style = style;
        this.productionYear = productionYear;
        this.ref = ref;
        this.imageSrc = imageSrc;
    }

    @NotNull
    private Integer idMovie;

    @NotBlank
    private String title;

    @NotNull
    private MovieStyles style;
    
    @NotNull
    private Integer productionYear;

    @NotBlank
    @Pattern(regexp="^[A-Z]{2,3}-\\d{5,6}$")
    private String ref;

    @NotBlank
    private String imageSrc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieStyles getStyle() {
        return style;
    }

    public void setStyle(MovieStyles style) {
        this.style = style;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
    
    
    
    
}
