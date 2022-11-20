package s22.movielist2.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import s22.movielist2.domain.CategoryRepository;
import s22.movielist2.domain.Movie;
import s22.movielist2.domain.MovieRepository;
import s22.movielist2.domain.MovieTypeRepository;

@Controller
public class MovieController {
	
	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private MovieTypeRepository trepository;
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	// List all movies
	@GetMapping("/listmovies")
	public String listMovies(Model model) {
		model.addAttribute("movies", repository.findAll());
		return "listmovies";
	}
	
	// Add a new movie
	@GetMapping("/addmovie")
	public String addMovie(Model model) {
		model.addAttribute("movie", new Movie());
		model.addAttribute("categories", crepository.findAll());
		model.addAttribute("types", trepository.findAll());
		return "addmovie";
	}
	
	// New movie validation
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/addmovie")
	public String movieSumbit(@Valid Movie movie, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", crepository.findAll());
			model.addAttribute("types", trepository.findAll());
			return "addmovie";
		}
		repository.save(movie);
		return "redirect:listmovies";
	}
	
	// Delete movie
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteMovie(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:../listmovies";
	}
	
	// Edit movie
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/editmovie/{id}")
	public String editMovie(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editmovie", repository.findById(id));
		model.addAttribute("categories", crepository.findAll());
		model.addAttribute("types", trepository.findAll());
		return "editmovie";
	}
	
	// Save edited movie
	@PostMapping("/save")
	public String save(Movie movie) {
		repository.save(movie);
		return "redirect:listmovies";
	}
	
}