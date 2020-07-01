package movies.moviedemo.controller;

import movies.moviedemo.domain.Movie;
import movies.moviedemo.dto.SuccessfulResponseDetail;
import movies.moviedemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.POST, value = "/movies")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie, @PathVariable Long accountId){
        movieService.addMovie(movie, accountId);
        HttpHeaders headers = new HttpHeaders();
        URI newMovieUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/movies")
                .buildAndExpand(movie.getId())
                .toUri();
        headers.setLocation(newMovieUri);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.CREATED.value(), "Added movie to account", movie);
        return new ResponseEntity<>(successfulResponseDetail, headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/movies")
    public ResponseEntity<Iterable<Movie>> getAllMoviesByAccountId(@PathVariable Long accountId){
        Iterable<Movie> movies = movieService.getAllMoviesByAccountId(accountId);
        SuccessfulResponseDetail responseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Success", movies);
        return new ResponseEntity(responseDetail, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/movies")
    public ResponseEntity<Iterable<Movie>> getAllMovies(){
        Iterable<Movie> movies = movieService.getAllMovies();
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Success", movies);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/movies/{movieId}" )
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable Long movieId){
        Optional<Movie> movies = movieService.getMovieById(movieId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Success", movies);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/movies/{movieId}")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie, @PathVariable Long movieId){
        movieService.updateMovie(movie, movieId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.ACCEPTED.value(), "Updated Movie", movie);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/movies/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long movieId){
        movieService.deleteMovieById(movieId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.NO_CONTENT.value(), "Deleted movie", null);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.NO_CONTENT);
    }
}
