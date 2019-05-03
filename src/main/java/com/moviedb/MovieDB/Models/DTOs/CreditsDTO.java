package com.moviedb.MovieDB.Models.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class CreditsDTO {
    private Long id;
    private List<CastCreditsDTO> cast;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CastCreditsDTO> getCast() {
        return cast;
    }

    public void setCast(List<CastCreditsDTO> cast) {
        this.cast = cast;
    }
}
