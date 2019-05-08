package com.moviedb.MovieDB.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

// @Data LOMBOCK
@Entity
@Table(name = "tb_movie")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private Long id;

    @Column(name = "movie_cl_title", nullable = false)
    private String title;

    @Column(name = "movie_cl_overview",length = 1500)
    private String overview;

    @Column(name = "movie_cl_origin")
    private String origin;

    @Column(name = "movie_cl_release_date")
    private Date release_date;

    @Column(name = "movie_cl_runtime")
    private int runtime;

    @Column(name = "movie_cl_original_language")
    private String original_language;

    @Column(name = "movie_cl_backdrop_path")
    private String backdrop_path;

    @Column(name = "movie_cl_poster_path")
    private String poster_path;

    //Lazy collection
    @JsonIgnore
    @OneToOne()
    private MoviePerson moviePerson;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE, CascadeType.REFRESH})
    private Set<Genres> genres;

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

    public Set<Genres> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genres> genres) {
        this.genres = genres;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    //Lingua
    //Year
}

