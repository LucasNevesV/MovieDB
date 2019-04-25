package com.moviedb.MovieDB.Controllers;

import com.moviedb.MovieDB.Models.Person;
import com.moviedb.MovieDB.Repositories.MovieRepository;
import com.moviedb.MovieDB.Repositories.PersonRepository;
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
@RequestMapping("/people")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(Pageable pageable){
        Page<Person> people= personRepository.findAll(pageable);

        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@Valid @RequestBody Person person){
        this.personRepository.save(person);
        return new ResponseEntity<>(person,HttpStatus.CREATED);
    }
}
