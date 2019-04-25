package com.moviedb.MovieDB.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "movie_cl_title", nullable = false)
    private String title;

    @Column(name = "movie_cl_overview")
    private String overview;

    @Column(name = "movie_cl_origin")
    private String origin;

    @Column(name = "movie_cl_runtime")
    private int runtime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="movie_has_people", joinColumns=
            {@JoinColumn(name="movie_id")}, inverseJoinColumns=
            {@JoinColumn(name="person_id")})
    private List<Person> cast;

    //Lingua
    //Year
}

