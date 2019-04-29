package com.moviedb.MovieDB.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_genres")
public class Genres {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "genres_cl_genres")
    private String genres;

    @JsonIgnore
    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Set<Movie> movies;

    @JsonIgnore
    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Set<TV> tvSet;

}
