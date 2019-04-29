package com.moviedb.MovieDB.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

// @Data LOMBOCK
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

    @Column(name = "movie_cl_language")
    private int language;

    //Lazy collection
    @JsonIgnore
    @OneToOne()
    private MoviePerson moviePerson;

    @ManyToMany(fetch = FetchType.LAZY,  cascade =
            {CascadeType.PERSIST, CascadeType.MERGE
            })
    @JoinTable(name="movie_has_genres", joinColumns=
            {@JoinColumn(name="movie_id")}, inverseJoinColumns=
            {@JoinColumn(name="genres_id")})
    private Genres genres;

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

    public MoviePerson getMoviePerson() {
        return moviePerson;
    }

    public void setMoviePerson(MoviePerson moviePerson) {
        this.moviePerson = moviePerson;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    //Lingua
    //Year
}

