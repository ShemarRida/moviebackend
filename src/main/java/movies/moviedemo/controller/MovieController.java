package movies.moviedemo.controller;

import movies.moviedemo.domain.Movie;
import movies.moviedemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.POST, value = "/movies")
    public void addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/movies/{movieId}" )
    public Optional<Movie> getMovieById(@PathVariable Long movieId){
         return movieService.getMovieById(movieId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/movies/{movieId}")
    public void updateMovie(@RequestBody Movie movie, @PathVariable Long movieId){
        movieService.updateMovie(movie, movieId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/movies/{movieId}")
    public void deleteMovie(@PathVariable Long movieId){
        movieService.deleteMovieById(movieId);
    }
}
