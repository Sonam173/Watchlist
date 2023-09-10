package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieRepository {
    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String, Director> directorDb = new HashMap<>();
    HashMap<String, List<String>> directorMoviePair = new HashMap<>();

    public String addMovie(Movie movie) {
        String key = movie.getName();
        movieDb.put(key, movie);
        return "Movie added successfully";
    }

    public String addDirector(Director director) {
        String key = director.getName();
        directorDb.put(key, director);
        return "Director added successfully";
    }

    public String addMovieDirectorPair(String movie, String director) {
       // directorMoviePair.put(movieName, directorName);
       // return "successfully";
        List<String> movies=directorMoviePair.get(director);
        if(movies==null)
        {
            movies = new ArrayList<>();

        }
        movies.add(movie);
        directorMoviePair.put(director,movies);
        return "successfully";
    }

    public Movie getMovieByName(String name) {

        return movieDb.get(name);
    }

    public Director getDirectorByName(String name) {
        return directorDb.get(name);
    }

    public List<String> getMoviesByDirectorName(String tName) {

        return directorMoviePair.get(tName);
    }

    public List<String> findAllMovies() {
        List<String> movies = new ArrayList<>();
        for (String s : movieDb.keySet()) {
            movies.add(s);
        }
        return movies;
    }

    public String deleteDirectorByName(String director) {
        for (String str : directorMoviePair.get(director)) {
            movieDb.remove(str);
        }
        directorMoviePair.remove(director);
        directorDb.remove(director);
        return "director deleted successfully";
    }

    public String deleteAllDirectors() {
        for (String director : directorDb.keySet()) {
            for (String str : directorMoviePair.get(director)) {
                movieDb.remove(str);
            }
            directorMoviePair.remove(director);
            directorDb.remove(director);

        }
        return "all director deleted successfully";
    }
}
