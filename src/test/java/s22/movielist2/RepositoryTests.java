package s22.movielist2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import s22.movielist2.domain.ApplicationUserRepository;
import s22.movielist2.domain.Category;
import s22.movielist2.domain.CategoryRepository;
import s22.movielist2.domain.Movie;
import s22.movielist2.domain.MovieRepository;
import s22.movielist2.domain.MovieType;
import s22.movielist2.domain.MovieTypeRepository;

@DataJpaTest
class RepositoryTests {
	
	@Autowired
	ApplicationUserRepository userRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	MovieTypeRepository movietypeRepository;
	
	@Test
	public void findMovie() {
		Movie movie = movieRepository.findById((long) 2).get();
		System.out.println("Haetaan id:llä 2 " + movie);
		assertEquals(movie.getTitle(), "Titanic");
	}
	
	@Test
	public void addMovie() {
		Movie movie = new Movie("Avatar", 2009, categoryRepository.findByName("Fantasy").get(0), movietypeRepository.findByName("Movie").get(0), 3);
		movieRepository.save(movie);
		assertNotNull(movie.getId());
	}
	
	@Test
	public void deleteMovie() {
		List<Movie> movies = movieRepository.findByTitle("Titanic");
		Movie movie = movies.get(0);
		movieRepository.delete(movie);
		List<Movie> newMovies = movieRepository.findByTitle("Titanic");
		assertThat(newMovies).hasSize(0);
	}
	
	@Test
	public void findCategory() {
		Category category = categoryRepository.findById((long) 1).get();
		System.out.println("Haetaan id:llä 1 " + category);
		assertEquals(category.getName(), "Romance");
	}
	
	@Test
	public void addCategory() {
		Category category = new Category("Comedy");
		categoryRepository.save(category);
		assertNotNull(category.getCategoryid());
	}
	
	@Test
	public void deleteCategory() {
		List<Category> categories = categoryRepository.findByName("Romance");
		Category category = categories.get(0);
		categoryRepository.delete(category);
		List<Category> newCategories = categoryRepository.findByName("Romance");
		assertThat(newCategories).hasSize(0);
	}
	
	@Test
	public void findType() {
		MovieType movietype = movietypeRepository.findById((long) 1).get();
		System.out.println("Haetaan id:llä 1 " + movietype);
		assertEquals(movietype.getName(), "Movie");
	}
	
	@Test
	public void addType() {
		MovieType movietype = new MovieType("Shortfilm");
		movietypeRepository.save(movietype);
		assertNotNull(movietype.getTypeid());
	}
	
	@Test
	public void deleteType() {
		List<MovieType> types = movietypeRepository.findByName("Series");
		MovieType movietype = types.get(0);
		movietypeRepository.delete(movietype);
		List<MovieType> newTypes = movietypeRepository.findByName("Series");
		assertThat(newTypes).hasSize(0);
	}
}