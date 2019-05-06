package com.moviedb.MovieDB.Repositories;

import com.moviedb.MovieDB.Models.TvEpisode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface TvEpisodeRepository extends JpaRepository<TvEpisode,Long> {

    List<TvEpisode> findAll();
    <S extends TvEpisode> S save(S entity);
}
