package com.moviedb.MovieDB.Controllers;


import com.moviedb.MovieDB.Models.Movie;
import com.moviedb.MovieDB.Repositories.MovieRepository;

import com.moviedb.MovieDB.utils.MovieFactory;
import com.moviedb.MovieDB.Filters.MovieSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    //@Autowired
    private MovieFactory movieFactory = new MovieFactory();

    @RequestMapping(value = "/movies",method = RequestMethod.GET)
    public ResponseEntity<?> getAll(Pageable pageable){
       /* movieFactory.addMovies();
        for (Movie movie : movieFactory.getMovies()) {
            this.movieRepository.save(movie);
        }*/
        Page<Movie> movies = movieRepository.findAll(pageable);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMovieById(@PathVariable Long id) {
        /*for (Movie movie: this.movieRepository.findAll()) {
            if (movie.getId().equals(id)) {
                return  new ResponseEntity<>(movie, HttpStatus.OK);

            }

        }*/
        Movie movie;
        movie = this.movieRepository.findById(id).get();
        return new ResponseEntity<>(movie, HttpStatus.OK);
        //return new ResponseEntity<>("There is no artist with this Id!", HttpStatus.NOT_FOUND);

    }
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createMovie(@Valid @RequestBody Movie movie){
        this.movieRepository.save(movie);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(path = "/update",method = RequestMethod.PUT)
    public ResponseEntity<?> updateMovie(@Valid @RequestBody Movie movie){
        System.out.println("Recebido");
        this.movieRepository.save(movie);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @RequestMapping(path = "/filter/", method = RequestMethod.GET)
    public ResponseEntity<?> getMovieByFields(Pageable pageable, @RequestParam(required = false)String title){
        Page<Movie> moviePage = movieRepository.findAll(MovieSpecification.searchMovie(title),pageable);
        return new ResponseEntity<>(moviePage,HttpStatus.OK);
    }


}
