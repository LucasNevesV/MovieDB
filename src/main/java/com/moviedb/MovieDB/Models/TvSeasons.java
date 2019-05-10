package com.moviedb.MovieDB.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_tv_seasons")
@JsonIgnoreProperties(ignoreUnknown = true)

public class TvSeasons {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tv_seasons_CL_name")
    private String name;

    @Column(name = "tv_seasons_CL_air_date")
    private String air_date;

    @Column(name = "tv_seasons_CL_episode_number")
    private int episode_count;

    @Column(name = "tv_seasons_CL_poster_path")
    private String poster_path;

    @Column(name = "tv_seasons_CL_overview",length = 3000)
    private String overview;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TvSeasons tvSeasons = (TvSeasons) o;

        return id != null ? id.equals(tvSeasons.id) : tvSeasons.id == null;
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

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public int getEpisode_count() {
        return episode_count;
    }

    public void setEpisode_count(int episode_count) {
        this.episode_count = episode_count;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
