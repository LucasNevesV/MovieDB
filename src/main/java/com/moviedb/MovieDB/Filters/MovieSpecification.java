package com.moviedb.MovieDB.Filters;

import com.moviedb.MovieDB.Models.Movie;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MovieSpecification {

    public static Specification<Movie> searchMovie(String title){
        return new Specification<Movie>() {
            @Override
            public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.or(cb.like(cb.upper(root.get("title")),("%" + title.toUpperCase() + "%")));
            }
        };
    }
}
