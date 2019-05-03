package com.moviedb.MovieDB.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_tv")
public class TV {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tv_cl_title", nullable = false)
    private String title;

    @Column(name = "tv_cl_overview")
    private String overview;

    @Column(name = "tv_cl_origin")
    private String origin;

    @Column(name = "tv_cl_language")
    private int language;

    @Column(name = "tv_cl_date")
    private String date;

    @Column(name = "tv_cl_seasons")
    private int seasons;

    @ManyToMany(fetch = FetchType.LAZY,  cascade =
            {CascadeType.PERSIST, CascadeType.MERGE
            })
    @JoinTable(name="tv_has_genres", joinColumns=
            {@JoinColumn(name="tv_id")}, inverseJoinColumns=
            {@JoinColumn(name="genres_id")})
    private Set<Genres> genres;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public Set<Genres> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genres> genres) {
        this.genres = genres;
    }
}
