package s22.movielist2.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MovieTypeRepository extends CrudRepository<MovieType, Long> {
	
	List<MovieType> findByName(String name);
	
}