package com.moviedb.MovieDB.Repositories;

import com.moviedb.MovieDB.Models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface GenderRepository extends JpaRepository<Gender,Long> {
    List<Gender> findAll();
    <S extends Gender> S save(S entity);
}
