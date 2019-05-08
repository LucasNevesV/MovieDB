package com.moviedb.MovieDB.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_tv")
@JsonIgnoreProperties(ignoreUnknown = true)

public class TV {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tv_cl_title", nullable = false)
    private String name;

    @Column(name = "tv_cl_overview",length = 1500)
    private String overview;

    @Column(name = "tv_cl_origin")
    private String origin;

    @Column(name = "tv_cl_language")
    private int language;

    @Column(name = "tv_cl_date")
    private String first_air_date;

    @Column(name = "tv_cl_seasons")
    private int number_of_seasons;

    @Column(name = "tv_cl_number_of_episodes")
    private int number_of_episodes;

    @ManyToMany(mappedBy = "tvSet", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE, CascadeType.REFRESH})
    private Set<Genres> genres;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "season_id")
    private List<TvSeasons> tvSeasons;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TV tv = (TV) o;

        return id != null ? id.equals(tv.id) : tv.id == null;
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public int getNumber_of_seasons() {
        return number_of_seasons;
    }

    public void setNumber_of_seasons(int number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
    }

    public Set<Genres> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genres> genres) {
        this.genres = genres;
    }

   public int getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(int number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

   public List<TvSeasons> getTvSeasons() {
        return tvSeasons;
    }

    public void setTvSeasons(List<TvSeasons> tvSeasons) {
        this.tvSeasons = tvSeasons;
    }
}
