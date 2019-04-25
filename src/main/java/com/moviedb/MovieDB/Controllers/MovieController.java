package com.moviedb.MovieDB.Controllers;

import com.moviedb.MovieDB.Models.Movie;
import com.moviedb.MovieDB.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(Pageable pageable){
        Page<Movie> movies = movieRepository.findAll(pageable);

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createMovie(@Valid @RequestBody Movie movie){
        this.movieRepository.save(movie);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }
}
