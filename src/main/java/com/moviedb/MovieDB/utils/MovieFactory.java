package com.moviedb.MovieDB.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviedb.MovieDB.Models.*;
import com.moviedb.MovieDB.Models.DTOs.CastCreditsDTO;
import com.moviedb.MovieDB.Models.DTOs.CreditsDTO;
import com.moviedb.MovieDB.Repositories.GenderRepository;
import com.moviedb.MovieDB.Repositories.MoviePersonRepository;
import com.moviedb.MovieDB.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.DataInput;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MovieFactory {

    private List<Movie> movies;
    private List<Genres> genres;
    private List<Person> people = new ArrayList<Person>();
    private List<MoviePerson> moviePersonList = new ArrayList<>();
    private List<String> movieCode;
    private List<TV> tvList = new ArrayList<TV>();
    MoviePersonRepository moviePersonRepository;
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
            for (int i = 1; i <4;i++){
                PopularMap popularMap = new PopularMap();
                try {
                    URL getPopular = new URL("https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey + "&language=en-US&page="+ i +"\n");
                    popularMap = objectMapper.readValue(getPopular,PopularMap.class);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (PopularMovieMap movieMap: popularMap.getResults()) {
                    movieId = movieMap.getId();
                    try {
                        URL getDetais = new URL("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey + "&language=en-US");
                        TimeUnit.MILLISECONDS.sleep(300);
                        Movie movie = objectMapper.readValue(getDetais,Movie.class);
                        movies.add(movie);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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

    public Person addPeople(Movie movie){
        PopularMap popularMap = new PopularMap();
        Person person = new Person();
        int count = 0;
        try {
            URL getMP= new URL("https://api.themoviedb.org/3/movie/" + movie.getId() + "/credits"+ "?api_key=" + apiKey + "&language=en-US");
            CreditsDTO creditsDTO = objectMapper.readValue(getMP, CreditsDTO.class);
            CastCreditsDTO castCredits;
            List<CastCreditsDTO> list = creditsDTO.getCast();
            MoviePerson mp = new MoviePerson();
            mp.setId(movie.getId());
            for (int i = 0; i < 5;i++){
                castCredits = list.get(i);
                try {
                    URL getPerson= new URL("https://api.themoviedb.org/3/person/" + castCredits.getId() + "?api_key=" + apiKey + "&language=en-US");
                    person = objectMapper.readValue(getPerson,Person.class);
                    //people.add(person);
                    System.out.println(person.getName());
                    TimeUnit.MILLISECONDS.sleep(250);
                    System.out.println("Ainda indo....");
                    List<MoviePerson> mpset = new ArrayList<>();
                    List<Person> peros = new ArrayList<>();
                    peros.add(person);
                    mp.setCast(peros);
                    if (person.getMoviePersonList() == null){

                    mpset.add(mp);
                    }else {

                    person.getMoviePersonList().add(mp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Corte");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

    public MoviePerson addMoviePerson(Movie movie){
        PopularMap popularMap = new PopularMap();
        MoviePerson mp = new MoviePerson();
        Person person = new Person();
        List<Person> cast = new ArrayList<Person>();
        mp.setId(movie.getId());
        int count = 0;
        try {
            URL getMP= new URL("https://api.themoviedb.org/3/movie/" + movie.getId() + "/credits"+ "?api_key=" + apiKey + "&language=en-US");
            CreditsDTO creditsDTO = objectMapper.readValue(getMP, CreditsDTO.class);
            CastCreditsDTO castCredits;
            List<CastCreditsDTO> list = creditsDTO.getCast();
            for (int i = 0; i < 5;i++){
                castCredits = list.get(i);
                try {
                    URL getPerson= new URL("https://api.themoviedb.org/3/person/" + castCredits.getId() + "?api_key=" + apiKey + "&language=en-US");
                    person = objectMapper.readValue(getPerson,Person.class);
                    System.out.println(person.getName());
                    TimeUnit.MILLISECONDS.sleep(250);
                    //System.out.println("Ainda indo....");
                    cast.add(person);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            mp.setCast(cast);
            System.out.println("Corte");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mp;
    }

    public MoviePerson addMoviePersonTV(TV movie){
        PopularMap popularMap = new PopularMap();
        MoviePerson mp = new MoviePerson();
        Person person = new Person();
        List<Person> cast = new ArrayList<Person>();
        mp.setId(movie.getId());
        int count = 0;
        try {
            URL getMP= new URL("https://api.themoviedb.org/3/tv/" + movie.getId() + "/credits"+ "?api_key=" + apiKey + "&language=en-US");
            CreditsDTO creditsDTO = objectMapper.readValue(getMP, CreditsDTO.class);
            CastCreditsDTO castCredits;
            List<CastCreditsDTO> list = creditsDTO.getCast();
            for (int i = 0; i < 5;i++){
                castCredits = list.get(i);
                try {
                    URL getPerson= new URL("https://api.themoviedb.org/3/person/" + castCredits.getId() + "?api_key=" + apiKey + "&language=en-US");
                    person = objectMapper.readValue(getPerson,Person.class);
                    System.out.println(person.getName());
                    TimeUnit.MILLISECONDS.sleep(250);
                    //System.out.println("Ainda indo....");
                    cast.add(person);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            mp.setCast(cast);
            System.out.println("Corte");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mp;
    }

    public void addTV(){
        for (int i = 1; i <4;i++) {
            PopularMap popularMap = new PopularMap();
            try {
                URL getPopular = new URL("https://api.themoviedb.org/3/tv/popular?api_key=" + apiKey +  "&language=en-US&page="+ i +"\n");
                popularMap = objectMapper.readValue(getPopular, PopularMap.class);

            } catch (Exception e) {
                e.printStackTrace();
            }
            for (PopularMovieMap movieMap : popularMap.getResults()) {
                movieId = movieMap.getId();
                try {
                    URL getDetais = new URL("https://api.themoviedb.org/3/tv/" + movieId + "?api_key=" + apiKey + "&language=en-US");
                    TimeUnit.MILLISECONDS.sleep(300);
                    TV tv = objectMapper.readValue(getDetais, TV.class);
                    System.out.println(tv.getName());
                    System.out.println(tv.getOverview().length());
                    tvList.add(tv);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
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

    public List<MoviePerson> getMoviePersonList() {
        return moviePersonList;
    }

    public void setMoviePersonList(List<MoviePerson> moviePersonList) {
        this.moviePersonList = moviePersonList;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<TV> getTvList() {
        return tvList;
    }

    public void setTvList(List<TV> tvList) {
        this.tvList = tvList;
    }
}
