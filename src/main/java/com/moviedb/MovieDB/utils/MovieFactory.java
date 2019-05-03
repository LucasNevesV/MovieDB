package com.moviedb.MovieDB.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviedb.MovieDB.Models.Genres;
import com.moviedb.MovieDB.Models.Movie;
import com.moviedb.MovieDB.Repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.DataInput;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MovieFactory {
    private List<Movie> movies;
    private List<Genres> genres;
    private List<String> movieCode;
    ObjectMapper objectMapper = new ObjectMapper();
    String apiKey = "17a74e8e1f3f8e57a29cbabd5eac4789";

    String movieId = "550";

        public MovieFactory() {
            ObjectMapper objectMapper = new ObjectMapper();
            movies = new ArrayList<Movie>();
            genres = new ArrayList<Genres>();
            try {
                URL getPopular = new URL("https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey + "&language=en-US&page=1\n");
                URL getDetais = new URL("https://api.themoviedb.org/3/movie/" + movieId + "/popular?api_key=" + apiKey + "&language=en-US");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
    }

    public void addMovies(){
            PopularMap popularMap = new PopularMap();
        try {
            URL getPopular = new URL("https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey + "&language=en-US&page=1\n");
            popularMap = objectMapper.readValue(getPopular,PopularMap.class);
            TimeUnit.MILLISECONDS.sleep(100);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (JsonMappingException e) {
        e.printStackTrace();
    } catch (JsonGenerationException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (PopularMovieMap movieMap: popularMap.getResults()) {
            movieId = movieMap.getId();
            try {
                URL getDetais = new URL("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey + "&language=en-US");
                Movie movie = objectMapper.readValue(getDetais,Movie.class);
                movies.add(movie);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void addGenres(){
        PopularMap popularMap = new PopularMap();
        try {
            URL getGeners = new URL("https://api.themoviedb.org/3/genre/movie/list?api_key="+apiKey+"&language=en-US\n");
            popularMap = objectMapper.readValue(getGeners,PopularMap.class);
            TimeUnit.MILLISECONDS.sleep(100);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Genres genres1: popularMap.getGenres()) {

                Genres toAdd;
                //toAdd =  objectMapper.readValue(genres1,Genres.class);
                genres.add(genres1);
        }
        try {
            URL getGeners = new URL("https://api.themoviedb.org/3/genre/tv/list?api_key="+apiKey+"&language=en-US\n");
            popularMap = objectMapper.readValue(getGeners,PopularMap.class);
            TimeUnit.MILLISECONDS.sleep(100);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Genres genres1: popularMap.getGenres()) {

            Genres toAdd;
            //toAdd =  objectMapper.readValue(genres1,Genres.class);
            genres.add(genres1);
        }
    };

    public void addPeople(){

    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }
}
