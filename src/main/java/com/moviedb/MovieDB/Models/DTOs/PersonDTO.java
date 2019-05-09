package com.moviedb.MovieDB.Models.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class PersonDTO {

    private Long Id;
    private String name;
    private String place_of_birth;
    private String birthday;
    private String biography;
    private String profile_path;
    private List<Long> moviePersonId;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public List<Long> getMoviePersonId() {
        return moviePersonId;
    }

    public void setMoviePersonId(List<Long> moviePersonId) {
        this.moviePersonId = moviePersonId;
    }
}
