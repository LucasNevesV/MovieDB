package com.moviedb.MovieDB.Controllers;

import com.moviedb.MovieDB.Models.Gender;
import com.moviedb.MovieDB.Repositories.GenderRepository;
import com.moviedb.MovieDB.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/genders")
public class GenderController {
    @Autowired
    private GenderRepository genderRepository;

    @RequestMapping(value = "/movies",method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        List<Gender> genders = genderRepository.findAll();
        return new ResponseEntity<>(genders, HttpStatus.OK);
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createMovie(@Valid @RequestBody Gender gender){
        this.genderRepository.save(gender);
        return new ResponseEntity<>(gender,HttpStatus.CREATED);
    }
}
