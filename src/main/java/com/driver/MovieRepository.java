package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    List<Movie> movielist = new ArrayList<>();
    List<Director> directorlist = new ArrayList<>();

    Map<String,ArrayList<String>> hm= new HashMap<>();

    String addMovie (Movie movie){
       movielist.add(movie);
       return "success" ;
    }

    String addDirector (Director director){
         directorlist.add(director);
         return "success";
    }

    String addMovieDirectorPair (String moviename, String directorname){

       if(!hm.containsKey(directorname)){
           hm.put(directorname,new ArrayList<>());
       }
       hm.get(directorname).add(moviename);

       return "success";

    }

    Movie getMovieByName (String name){
        for(Movie movie: movielist){
            if(movie.getName().equals(name)){
                return movie;
            }
        }
        return null;
    }

    Director getDirectorByName (String name){

        for(Director director: directorlist){
            if(director.getName().equals(name)){
                return director;
            }
        }
          return null;
    }

    List<String> getMoviesByDirectorName(String directorname){

         return hm.get(directorname);
    }

    List<String> findAllMovies(){
        List<String> movienamelist = new ArrayList<>();
        for(Movie movie:movielist){
            movienamelist.add(movie.getName());
        }
        return movienamelist;
    }


    String deleteDirectorByName (String directorname){

         hm.remove(directorname);

         return "success";
    }

    String deleteAllDirectors (){
        Set<String> hs = new HashSet<>();
       for(List<String> li : hm.values()){
          for(String s:li) hs.add(s);
       }

       for(Movie movie:movielist){
           if(hs.contains(movie.getName())){
               movielist.remove(movie);
           }
       }
       hm.clear();
       directorlist.clear();
       return "success";
    }

}