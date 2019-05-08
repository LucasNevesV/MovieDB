package com.moviedb.MovieDB.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tv_episodes")
@JsonIgnoreProperties(ignoreUnknown = true)

public class TvEpisode {

    @Id
    private Long id;

    @Column(name = "tv_episodes_CL_name")
    private String name;

    @Column(name = "tv_episodes_CL_air_date")
    private String air_date;

    @Column(name = "tv_episodes_CL_episode_number")
    private int episode_number;

    @Column(name = "tv_episodes_CL_overview",length = 1500)
    private String overview;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TvEpisode tvEpisode = (TvEpisode) o;

        return id != null ? id.equals(tvEpisode.id) : tvEpisode.id == null;
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

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public int getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(int episode_number) {
        this.episode_number = episode_number;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
