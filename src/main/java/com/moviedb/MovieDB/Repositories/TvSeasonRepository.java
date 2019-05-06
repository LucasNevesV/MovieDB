package com.moviedb.MovieDB.Repositories;

import com.moviedb.MovieDB.Models.TvSeasons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface TvSeasonRepository extends JpaRepository<TvSeasons,Long> {

    List<TvSeasons> findAll();
    <S extends TvSeasons> S save(S entity);
}
