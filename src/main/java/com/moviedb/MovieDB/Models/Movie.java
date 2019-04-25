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

    //Lazy collection
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="movie_has_people", joinColumns=
            {@JoinColumn(name="movie_id")}, inverseJoinColumns=
            {@JoinColumn(name="person_id")})
    private List<Person> cast;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return id != null ? id.equals(movie.id) : movie.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<Person> getCast() {
        return cast;
    }

    public void setCast(List<Person> cast) {
        this.cast = cast;
    }

    //Lingua
    //Year
}

