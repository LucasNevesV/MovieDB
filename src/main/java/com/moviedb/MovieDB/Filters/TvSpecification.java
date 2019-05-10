package com.moviedb.MovieDB.Filters;

import com.moviedb.MovieDB.Models.TV;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TvSpecification {
    public static Specification<TV> searchTv(String title){
        return new Specification<TV>() {
            @Override
            public Predicate toPredicate(Root<TV> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.or(cb.like(cb.upper(root.get("name")),("%" + title.toUpperCase() + "%")));
            }
        };
    }
}
