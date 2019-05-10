package com.moviedb.MovieDB.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "tb_person")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "person_cl_name", nullable = false)
    private String name;

    @Column(name = "person_cl_origin")
    private String place_of_birth;

    @Column(name = "person_cl_birthday")
    private String birthday;

    @Size(max = 100000)
    @Column(name = "person_cl_biography")
    private String biography;

    @Column(name = "person_cl_profile_path")
    private String profile_path;

    @JsonIgnore
    @ManyToMany(mappedBy = "cast", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private List<MoviePerson> moviePersonList ;

    /*@ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "gender_id")
    private Gender gender;*/

    @Column(name = "person_cl_gender")
    private int gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id != null ? id.equals(person.id) : person.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<MoviePerson> getMoviePersonList() {
        return moviePersonList;
    }

    public void setMoviePersonList(List<MoviePerson> moviePersonList) {
        this.moviePersonList = moviePersonList;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
}
