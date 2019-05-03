package com.moviedb.MovieDB.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.moviedb.MovieDB.Models.Genres;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PopularMap {

    private int page;

    private List<PopularMovieMap> results;

    private List<Genres> genres;

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }


    public List<PopularMovieMap> getResults() {
        return results;
    }

    public void setResults(List<PopularMovieMap> results) {
        this.results = results;
    }
}
