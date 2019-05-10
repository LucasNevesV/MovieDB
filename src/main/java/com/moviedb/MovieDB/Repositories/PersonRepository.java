package com.moviedb.MovieDB.Repositories;

import com.moviedb.MovieDB.Models.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    Page<Person> findAll(Specification<Person> movieSpecification, Pageable pageable);
    <S extends Person> S save(S entity);
}
