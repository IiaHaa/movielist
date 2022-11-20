package s22.movielist2.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import s22.movielist2.domain.Category;
import s22.movielist2.domain.CategoryRepository;

@RestController
public class CategoryRestController {
	
	@Autowired
	private CategoryRepository repository;
	
	// RESTful service to get all categories
	@GetMapping("/categories")
	public @ResponseBody List<Category> categoryListRest() {
		return (List<Category>) repository.findAll();
	}
}