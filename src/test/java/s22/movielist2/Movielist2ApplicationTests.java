package s22.movielist2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import s22.movielist2.web.CategoryRestController;
import s22.movielist2.web.MovieController;
import s22.movielist2.web.MovieRestController;
import s22.movielist2.web.MovieTypeRestController;

@SpringBootTest
class Movielist2ApplicationTests {
	
	@Autowired
	MovieController movieController;
	
	@Autowired
	MovieRestController movieRestController;
	
	@Autowired
	CategoryRestController categoryRestController;
	
	@Autowired
	MovieTypeRestController movieTypeRestController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(movieController).isNotNull();
		assertThat(movieRestController).isNotNull();
		assertThat(categoryRestController).isNotNull();
		assertThat(movieTypeRestController).isNotNull();
	}

}