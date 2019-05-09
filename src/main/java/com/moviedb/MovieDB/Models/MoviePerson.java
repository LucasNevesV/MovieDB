package com.moviedb.MovieDB.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_movie_person")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoviePerson {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "movie_id")
    private Movie movie;


    //@JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="movie_has_people", joinColumns=
            {@JoinColumn(name="movie_id")}, inverseJoinColumns=
            {@JoinColumn(name="people_id")})
    private List<Person> cast;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoviePerson that = (MoviePerson) o;

        return id != null ? id.equals(that.id) : that.id == null;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Person> getCast() {
        return cast;
    }

    public void setCast(List<Person> cast) {
        this.cast = cast;
    }
}
