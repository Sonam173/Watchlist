package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie)
    {
        String ans =movieRepository.addMovie(movie);
        return ans;
    }

    public String addDirector(Director director)
    {
        String ans =movieRepository.addDirector(director);
        return ans;
    }
    public String addMovieDirectorPair(String movieName,String directorName)
    {
        return movieRepository.addMovieDirectorPair(movieName,directorName);
    }

    public Movie getMovieByName(String name)
    {
        Movie movie=movieRepository.getMovieByName(name);
        return movie;
    }

    public Director getDirectorByName(String name)
    {
        Director director=movieRepository.getDirectorByName(name);
        return director;
    }
    public List<String>getMoviesByDirectorName(String tName)
    {

        List<String> list =movieRepository.getMoviesByDirectorName(tName);
        return list;
    }
    public List<String> findAllMovies() {
        List<String> list =movieRepository.findAllMovies();
        return list;
    }
    public String deleteDirectorByName(String director)
    {

        String ans=movieRepository.deleteDirectorByName(director);
        return ans;
    }
    public String deleteAllDirectors()
    {

        String ans=movieRepository.deleteAllDirectors();
        return ans;
    }

}
