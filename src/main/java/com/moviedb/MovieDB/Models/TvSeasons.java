package com.moviedb.MovieDB.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_tv_seasons")
@JsonIgnoreProperties(ignoreUnknown = true)

public class TvSeasons {

    @Id
    private Long id;

    @Column(name = "tv_seasons_CL_air_date")
    private String air_date;

    @Column(name = "tv_seasons_CL_episode_number")
    private int episode_number;

    @Column(name = "tv_seasons_CL_overview",length = 1500)
    private String overview;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "episode_id")
    private List<TvEpisode> tvEpisode;

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
