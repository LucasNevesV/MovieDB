package com.moviedb.MovieDB.Controllers;

import com.moviedb.MovieDB.Filters.TvSpecification;
import com.moviedb.MovieDB.Models.TV;
import com.moviedb.MovieDB.Repositories.TvRepository;
import com.moviedb.MovieDB.utils.MovieFactory;
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
@RequestMapping("/tvs")
public class TvController {

    @Autowired
    private TvRepository tvRepository;

    private MovieFactory movieFactory = new MovieFactory();

    @RequestMapping(value = "/tvs",method = RequestMethod.GET)
    public ResponseEntity<?> getAll(Pageable pageable){
       /* movieFactory.addTV();
        for (TV tv : movieFactory.getTvList()) {
            System.out.println(tv.getName());
            this.tvRepository.save(tv);
        }*/
        Page<TV> movies = tvRepository.findAll(pageable);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMovieById(@PathVariable Long id) {
        /*for (Movie movie: this.movieRepository.findAll()) {
            if (movie.getId().equals(id)) {
                return  new ResponseEntity<>(movie, HttpStatus.OK);

            }

        }*/
        TV tv;
        tv = this.tvRepository.findById(id).get();
        return new ResponseEntity<>(tv, HttpStatus.OK);
        //return new ResponseEntity<>("There is no artist with this Id!", HttpStatus.NOT_FOUND);

    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(path = "/update",method = RequestMethod.PUT)
    public ResponseEntity<?> updateMovie(@Valid @RequestBody TV tv){
        this.tvRepository.save(tv);
        return new ResponseEntity<>(tv,HttpStatus.OK);
    }

    @RequestMapping(path = "/filter/", method = RequestMethod.GET)
    public ResponseEntity<?> getMovieByFields(Pageable pageable, @RequestParam(required = false)String title){
        Page<TV> tvPage = tvRepository.findAll(TvSpecification.searchTv(title),pageable);
        return new ResponseEntity<>(tvPage,HttpStatus.OK);
    }
}
