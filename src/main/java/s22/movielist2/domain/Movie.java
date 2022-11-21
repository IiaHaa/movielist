package s22.movielist2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1, max=70, message="Name the movie")
	private String title;
	
	@JoinColumn(name = "movieyear")
	@Range(min=1888, max=2022, message="Year must be between 1888 and 2022")
	@Column(name = "movieyear")
	private int movieYear;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "typeid")
	private MovieType movietype;
	
	@Range(min=0, max=5, message="Rating must be between 0 and 5")
	private int rating;
	
	public Movie() {
		super();
	}

	public Movie(String title, int movieYear, Category category, MovieType movietype, int rating) {
		super();
		this.title = title;
		this.movieYear = movieYear;
		this.category = category;
		this.movietype = movietype;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public MovieType getMovietype() {
		return movietype;
	}

	public void setMovietype(MovieType movietype) {
		this.movietype = movietype;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", movieYear=" + movieYear + ", rating=" + rating + "]";
	}
	
}