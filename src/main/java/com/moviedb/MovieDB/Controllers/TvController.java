package com.moviedb.MovieDB.Controllers;

import com.moviedb.MovieDB.Models.TV;
import com.moviedb.MovieDB.Repositories.TvRepository;
import com.moviedb.MovieDB.utils.MovieFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tvs")
public class TvController {

    @Autowired
    private TvRepository tvRepository;

    private MovieFactory movieFactory = new MovieFactory();

    @RequestMapping(value = "/tvs",method = RequestMethod.GET)
    public ResponseEntity<?> getAll(Pageable pageable){
        movieFactory.addTV();
        for (TV tv : movieFactory.getTvList()) {
            System.out.println(tv.getName());
            this.tvRepository.save(tv);
        }
        Page<TV> movies = tvRepository.findAll(pageable);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
