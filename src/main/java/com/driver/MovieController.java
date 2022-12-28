package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

   @Autowired
   MovieService movieService;





    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie (@RequestBody Movie movie){
        String res =movieService.addMovie(movie);

        return  new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector (@RequestBody Director director){
        String res =movieService.addDirector(director);

        return  new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @PutMapping("/movies/add-movie-director-pair")

    public ResponseEntity<String> addMovieDirectorPair (@RequestParam("moviename") String moviename, @RequestParam("directorname") String directorname){
        String res =movieService.addMovieDirectorPair(moviename,directorname);

        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }


    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName (@PathVariable("name") String name){
       Movie movie= movieService.getMovieByName(name);
       if(movie==null) return new ResponseEntity(movie,HttpStatus.BAD_REQUEST);

       return new ResponseEntity(movie, HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName (@PathVariable("name") String name){
         Director director = movieService.getDirectorByName(name);

        if(director==null) return new ResponseEntity(director,HttpStatus.BAD_REQUEST);

        return new ResponseEntity(director,HttpStatus.ACCEPTED);
    }


    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName (@PathVariable("director") String directorname){
       List<String> li =  movieService.getMoviesByDirectorName(directorname);
       return  new ResponseEntity<>(li,HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movienamelist = movieService.findAllMovies();

        return  new ResponseEntity<>(movienamelist,HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName (@RequestParam("director’s name") String directorname){
        String res =movieService.deleteDirectorByName(directorname);

         return  new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors (){
        String res = movieService.deleteAllDirectors();
        return  new ResponseEntity<>(res,HttpStatus.FOUND);
    }
}
