package s22.movielist2.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import s22.movielist2.domain.Movie;
import s22.movielist2.domain.MovieRepository;

@RestController
public class MovieRestController {
	
	@Autowired
	private MovieRepository repository;

	// RESTful service to get all movies
	@GetMapping("/movies")
	public @ResponseBody List<Movie> movieListRest() {
		return (List<Movie>) repository.findAll();
	}
	
	// RESTful service to get movie by id
	@GetMapping("/movie/{id}")
	public @ResponseBody Optional<Movie> findMovieRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}
}