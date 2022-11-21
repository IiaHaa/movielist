package s22.movielist2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s22.movielist2.domain.ApplicationUser;
import s22.movielist2.domain.ApplicationUserRepository;
import s22.movielist2.domain.Category;
import s22.movielist2.domain.CategoryRepository;
import s22.movielist2.domain.Movie;
import s22.movielist2.domain.MovieRepository;
import s22.movielist2.domain.MovieType;
import s22.movielist2.domain.MovieTypeRepository;

@SpringBootApplication
public class Movielist2Application {
	
	@Autowired
	MovieRepository repository;
	
	@Autowired
	CategoryRepository crepository;
	
	@Autowired
	MovieTypeRepository trepository;
	
	@Autowired
	ApplicationUserRepository urepository;

	public static void main(String[] args) {
		SpringApplication.run(Movielist2Application.class, args);
	}
	
	//@Bean
	//public CommandLineRunner movielistDemo(MovieRepository repository, CategoryRepository crepository, MovieTypeRepository trepository) {
		//return (args) -> {
			//crepository.save(new Category("Romance"));
			//crepository.save(new Category("Fantasy"));
	//crepository.save(new Category("Crime"));
	//crepository.save(new Category("Christmas"));
	//crepository.save(new Category("Adventure"));
	//crepository.save(new Category("Sci-Fi"));
			
	//trepository.save(new MovieType("Movie"));
	//trepository.save(new MovieType("Series"));
	//trepository.save(new MovieType("Animation"));
			
	//repository.save(new Movie("A Christmas Prince", 2017, crepository.findByName("Christmas").get(0), trepository.findByName("Movie").get(0), 4));
	//repository.save(new Movie("Titanic", 1997, crepository.findByName("Romance").get(0), trepository.findByName("Movie").get(0), 5));
	//repository.save(new Movie("Arrival", 2016, crepository.findByName("Sci-Fi").get(0), trepository.findByName("Movie").get(0), 5));
	
	//urepository.save(new ApplicationUser("Iia", "Haavanoksa", "ADMIN", "admin", "$2a$10$o8K05.mEbvG9jYxf2PfjcefZ4dVd907Bgh6H/n5k8w5hiEWiZS1BS"));
	//urepository.save(new ApplicationUser("Test", "User", "USER", "user", "$2a$10$inW.vQUwsaOiPFWKBIqdq.yGHZ68dQAs7a22m6xbS0Ax6YzqzSgA2"));
	//	};
	//}

}
