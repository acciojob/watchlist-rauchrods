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

    String addMovie (Movie movie){
       return movieRepository.addMovie(movie);
    }

    String addDirector (Director director){
       return movieRepository.addDirector(director);
    }

    String addMovieDirectorPair (String moviename, String directorname){
       return  movieRepository.addMovieDirectorPair(moviename,directorname);
    }

    Movie getMovieByName (String name){
        return movieRepository.getMovieByName(name);
    }

    Director getDirectorByName (String name){
         return  movieRepository.getDirectorByName(name);
    }

    List<String> getMoviesByDirectorName (String directorname){
       return movieRepository.getMoviesByDirectorName(directorname);
    }

    List<String> findAllMovies(){
         return movieRepository.findAllMovies();
    }

    String deleteDirectorByName (String directorname){
       return  movieRepository.deleteDirectorByName(directorname);

    }

    String deleteAllDirectors (){
        return movieRepository.deleteAllDirectors();
    }
}
