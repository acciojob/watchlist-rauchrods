package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    public List<Movie> movielist ;
    public List<Director> directorlist ;
    public Map<String,ArrayList<String>> hm;


    public MovieRepository(){
        movielist= new ArrayList<>();
        directorlist = new ArrayList<>();
        hm= new HashMap<>();
    }

    public String addMovie (Movie movie){
       movielist.add(movie);
       return "success" ;
    }

    public String addDirector (Director director){
         directorlist.add(director);
         return "success";
    }

    public String addMovieDirectorPair (String moviename, String directorname){

       if(!hm.containsKey(directorname)){
           hm.put(directorname,new ArrayList<>());
       }
       hm.get(directorname).add(moviename);

       return "success";

    }

    public Movie getMovieByName (String name){
        for(Movie movie: movielist){
            if(movie.getName().equals(name)){
                return movie;
            }
        }
        return null;
    }

    public Director getDirectorByName (String name){

        for(Director director: directorlist){
            if(director.getName().equals(name)){
                return director;
            }
        }
          return null;
    }

    public List<String> getMoviesByDirectorName(String directorname){

         return hm.get(directorname);
    }

    public List<String> findAllMovies(){
        List<String> movienamelist = new ArrayList<>();
        for(Movie movie:movielist){
            movienamelist.add(movie.getName());
        }
        return movienamelist;
    }


    public String deleteDirectorByName (String directorname){
        Set<String> hs = new HashSet<>();
         List<String> li = hm.get(directorname);
         hm.remove(directorname);
        for(String s:li) {
            hs.add(s);
        }
//        for(int i=0;i<movielist.size();i++){
//            if(hs.contains(movielist.get(i).getName())){
//                movielist.remove(i);
//            }
//        }

        for(Movie movie:movielist){
            if(hs.contains(movie.getName())){
                movielist.remove(movie);
            }
        }
//        for(int i=0;i<directorlist.size();i++){
//            if(hs.contains(directorlist.get(i).getName())){
//                directorlist.remove(i);
//            }
//        }

        for(Director director:directorlist){
            if(director.getName().equals(directorname)){
                directorlist.remove(director);
            }
        }
         return "success";
    }

    public String deleteAllDirectors (){
        Set<String> hs = new HashSet<>();
       for(List<String> li : hm.values()){
          for(String s:li) hs.add(s);
       }

//        for(int i=0;i<movielist.size();i++){
//            if(hs.contains(movielist.get(i).getName())){
//                movielist.remove(i);
//            }
//        }

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
