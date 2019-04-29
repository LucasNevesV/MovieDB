package com.moviedb.MovieDB.Models;

import javax.persistence.*;

@Entity
@Table(name = "tb_tv")
public class TV {

    @Column(name = "movie_cl_title", nullable = false)
    private String title;

    @Column(name = "movie_cl_overview")
    private String overview;

    @Column(name = "movie_cl_origin")
    private String origin;

    @Column(name = "movie_cl_language")
    private int language;

    @ManyToMany(fetch = FetchType.LAZY,  cascade =
            {CascadeType.PERSIST, CascadeType.MERGE
            })
    @JoinTable(name="tv_has_genres", joinColumns=
            {@JoinColumn(name="tv_id")}, inverseJoinColumns=
            {@JoinColumn(name="genres_id")})
    private Genres genres;
}
