package s22.movielist2.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import s22.movielist2.domain.MovieType;
import s22.movielist2.domain.MovieTypeRepository;

@RestController
public class MovieTypeRestController {
	
	@Autowired
	private MovieTypeRepository repository;
	
	// RESTful service to get all categories
	@GetMapping("/types")
	public @ResponseBody List<MovieType> movieTypeListRest() {
		return (List<MovieType>) repository.findAll();
	}
}