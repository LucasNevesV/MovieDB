package com.moviedb.MovieDB.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_movie_person")
public class MoviePerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie")
    private Movie movie;

    @JoinColumn(name = "tb_role")
    private String role;

    @ManyToMany(fetch = FetchType.LAZY,  cascade =
            {CascadeType.PERSIST, CascadeType.MERGE
            })
    @JoinTable(name="movie_has_people", joinColumns=
            {@JoinColumn(name="movie_id")}, inverseJoinColumns=
            {@JoinColumn(name="people_id")})
    private Set<Person> people;


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

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }
}
