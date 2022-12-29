package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MovieService {

     @Autowired
     MovieRepository movieRepository;

    public String addMovie (Movie movie){
       return movieRepository.addMovie(movie);
    }

    public String addDirector (Director director){
       return movieRepository.addDirector(director);
    }

    public String addMovieDirectorPair (String moviename, String directorname){
       return  movieRepository.addMovieDirectorPair(moviename,directorname);
    }

    public Movie getMovieByName (String name){
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName (String name){
         return  movieRepository.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName (String directorname){
       return movieRepository.getMoviesByDirectorName(directorname);
    }

    public List<String> findAllMovies(){
         return movieRepository.findAllMovies();
    }

    public String deleteDirectorByName (String directorname){
       return  movieRepository.deleteDirectorByName(directorname);

    }

    public String deleteAllDirectors (){
        return movieRepository.deleteAllDirectors();
    }
}
