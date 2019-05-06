package com.moviedb.MovieDB.Controllers;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.moviedb.MovieDB.Models.Movie;
import com.moviedb.MovieDB.Models.MoviePerson;
import com.moviedb.MovieDB.Repositories.MoviePersonRepository;
import com.moviedb.MovieDB.Repositories.MovieRepository;
import com.moviedb.MovieDB.utils.MovieFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@RestController
@RequestMapping("/movieperson")
public class MoviePerrsonController {

    @Autowired
    private MoviePersonRepository moviePersonRepository;

    @Autowired
    private MovieRepository movieRepository;

    private MovieFactory movieFactory = new MovieFactory();


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(Pageable pageable){
        for (Movie movie: movieRepository.findAll()) {
            this.moviePersonRepository.save(movieFactory.addMoviePerson(movie));
            System.out.println("FOi");
        }
        Page<MoviePerson> moviePeople = moviePersonRepository.findAll(pageable);
        return new ResponseEntity<>(moviePeople, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMovieById(@PathVariable Long id) {
        for (MoviePerson moviePeople: this.moviePersonRepository.findAll()) {
            if (moviePeople.getId().equals(id)) {
                return  new ResponseEntity<>(moviePeople, HttpStatus.OK);

            }

        }
        return new ResponseEntity<>("There is no artist with this Id!", HttpStatus.NOT_FOUND);

    }
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createMovie(@Valid @RequestBody MoviePerson moviePeople){
        this.moviePersonRepository.save(moviePeople);
        return new ResponseEntity<>(moviePeople,HttpStatus.CREATED);
    }
}
