package movies.moviedemo.service;

import movies.moviedemo.domain.Accounts;
import movies.moviedemo.domain.Movie;
import movies.moviedemo.exceptions.ResourceNotFoundException;
import movies.moviedemo.repository.AccountRepository;
import movies.moviedemo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    private AccountRepository accountRepository;

    protected void verifyMovie(Long movieId) throws ResourceNotFoundException {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isEmpty()) {
            throw new ResourceNotFoundException("Movie with id " + movieId + " not found");
        }
    }

    public void addMovie(Movie movie, Long accountId) {
        for (Accounts account : accountRepository.findAll()) {
            if (account.getUserId().equals(accountId)) {
                movie.setAccounts(account);
                movieRepository.save(movie);
            }
        }
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }

    public List<Movie> getAllMoviesByAccountId(Long id) {
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }

    public Optional<Movie> getMovieById(Long movieId) {
        verifyMovie(movieId);
        return movieRepository.findById(movieId);
    }

    public void updateMovie(Movie movie, Long movieId) {
        verifyMovie(movieId);
        for (Accounts account : accountRepository.findAll()) {
            movie.setAccounts(account);
            for (Movie movie1 : movieRepository.findAll()) {
                if (movie1.getId().equals(movieId)) {
                    movieRepository.save(movie);
                }
            }
        }
    }

        public void deleteMovieById(Long movieId){
            verifyMovie(movieId);
            movieRepository.deleteById(movieId);
        }

    }

