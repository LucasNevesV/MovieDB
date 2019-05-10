package com.moviedb.MovieDB.Filters;

import com.moviedb.MovieDB.Models.Person;
import com.moviedb.MovieDB.Models.TV;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PersonSpecification {
    public static Specification<Person> searchPerson(String title){
        return new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.or(cb.like(cb.upper(root.get("name")),("%" + title.toUpperCase() + "%")));
            }
        };
    }
}
