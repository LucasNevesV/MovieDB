package com.moviedb.MovieDB.Repositories;

import com.moviedb.MovieDB.Models.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface GenreRepository extends JpaRepository<Genres,Long> {
    List<Genres> findAll();
    <S extends Genres> S save(S entity);
}
