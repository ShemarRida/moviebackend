package movies.moviedemo.repository;

import movies.moviedemo.domain.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
