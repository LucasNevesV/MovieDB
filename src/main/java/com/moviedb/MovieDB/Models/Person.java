package com.moviedb.MovieDB.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "person_cl_name", nullable = false)
    private String name;

    @Column(name = "person_cl_origin")
    private String origin;

    @ManyToMany(mappedBy = "cast", fetch = FetchType.EAGER)
    private List<Movie> movies;

}
