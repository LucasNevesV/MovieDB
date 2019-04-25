package com.moviedb.MovieDB.Repositories;

import com.moviedb.MovieDB.Models.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    Page<Movie> findAll(Pageable pageable);
    <S extends Movie> S save(S entity);
}
