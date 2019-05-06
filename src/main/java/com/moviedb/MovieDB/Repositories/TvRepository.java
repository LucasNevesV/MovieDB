package com.moviedb.MovieDB.Repositories;

import com.moviedb.MovieDB.Models.TV;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface TvRepository extends JpaRepository<TV,Long> {
    List<TV> findAll();
    <S extends TV> S save(S entity);
}
