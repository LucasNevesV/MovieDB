package com.moviedb.MovieDB.Repositories;

import com.moviedb.MovieDB.Models.MoviePerson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository

public interface MoviePersonRepository extends JpaRepository<MoviePerson,Long> {
    Page<MoviePerson> findAll(Pageable pageable);
    <S extends MoviePerson> S save(S entity);
}
