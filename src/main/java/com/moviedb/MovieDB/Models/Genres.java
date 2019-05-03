package com.moviedb.MovieDB.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_genres")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Genres {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "genres_cl_name")
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,  cascade =
            {CascadeType.PERSIST, CascadeType.MERGE
            })
    @JoinTable(name="genres_has_movies", joinColumns=
            {@JoinColumn(name="genres_id")}, inverseJoinColumns=
            {@JoinColumn(name="movies_id")})
    private Set<Movie> movies;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,  cascade =
            {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.REMOVE,CascadeType.REFRESH
            })
    @JoinTable(name="genres_has_movies", joinColumns=
            {@JoinColumn(name="genres_id")}, inverseJoinColumns=
            {@JoinColumn(name="movies_id")})
    private Set<TV> tvSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Set<TV> getTvSet() {
        return tvSet;
    }

    public void setTvSet(Set<TV> tvSet) {
        this.tvSet = tvSet;
    }
}
