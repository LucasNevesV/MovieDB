package com.moviedb.MovieDB.Controllers;


import com.moviedb.MovieDB.Models.Movie;
import com.moviedb.MovieDB.Repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "/movies",method = RequestMethod.GET)
    public ResponseEntity<?> getAll(Pageable pageable){
        Page<Movie> movies = movieRepository.findAll(pageable);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMovieById(@PathVariable Long id) {
        for (Movie movie: this.movieRepository.findAll()) {
            if (movie.getId().equals(id)) {
                return  new ResponseEntity<>(movie, HttpStatus.OK);

            }

        }
        return new ResponseEntity<>("There is no artist with this Id!", HttpStatus.NOT_FOUND);

    }
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createMovie(@Valid @RequestBody Movie movie){
        this.movieRepository.save(movie);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }
}
