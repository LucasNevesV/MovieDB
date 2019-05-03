package com.moviedb.MovieDB.Controllers;

import com.moviedb.MovieDB.Models.Gender;
import com.moviedb.MovieDB.Models.Genres;
import com.moviedb.MovieDB.Models.Movie;
import com.moviedb.MovieDB.Repositories.GenreRepository;
import com.moviedb.MovieDB.utils.MovieFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    private MovieFactory movieFactory = new MovieFactory();

    @RequestMapping(value = "/genres",method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        movieFactory.addGenres();
        for (Genres genres: movieFactory.getGenres()) {
            this.genreRepository.save(genres);
        }
        List<Genres> genres = genreRepository.findAll();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createGenres(@Valid @RequestBody Genres genres){
        this.genreRepository.save(genres);
        return new ResponseEntity<>(genres,HttpStatus.CREATED);
    }
}
