package com.moviedb.MovieDB.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviedb.MovieDB.Filters.PersonSpecification;
import com.moviedb.MovieDB.Models.DTOs.PersonDTO;
import com.moviedb.MovieDB.Models.Movie;
import com.moviedb.MovieDB.Models.MoviePerson;
import com.moviedb.MovieDB.Models.Person;
import com.moviedb.MovieDB.Repositories.MovieRepository;
import com.moviedb.MovieDB.Repositories.PersonRepository;
import com.moviedb.MovieDB.utils.MovieFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/people")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    private MovieFactory movieFactory = new MovieFactory();

    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(Pageable pageable){
        Page<Person> people= personRepository.findAll(pageable);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMovieById(@PathVariable Long id) {
        Person person;

        person = this.personRepository.findById(id).get();

        return new ResponseEntity<>(person, HttpStatus.OK);
        //return new ResponseEntity<>("There is no artist with this Id!", HttpStatus.NOT_FOUND);

    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createPerson(@Valid @RequestBody Person person){
        this.personRepository.save(person);
        return new ResponseEntity<>(person,HttpStatus.CREATED);
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(path = "/update",method = RequestMethod.PUT)
    public ResponseEntity<?> updateMovie(@Valid @RequestBody Person person){
        this.personRepository.save(person);
        return new ResponseEntity<>(person,HttpStatus.OK);
    }

    @RequestMapping(path = "/filter/", method = RequestMethod.GET)
    public ResponseEntity<?> getMovieByFields(Pageable pageable, @RequestParam(required = false)String title){
        Page<Person> personPagePage = personRepository.findAll(PersonSpecification.searchPerson(title),pageable);
        return new ResponseEntity<>(personPagePage,HttpStatus.OK);
    }
}
