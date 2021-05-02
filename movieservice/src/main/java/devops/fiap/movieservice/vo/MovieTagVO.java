package devops.fiap.movieservice.vo;

import java.util.List;

import devops.fiap.movieservice.entity.Movie;

public class MovieTagVO {
	
	private String tag;
	
	private List<Movie> movies;

	public MovieTagVO(String tag, List<Movie> movies) {
		super();
		this.tag = tag;
		this.movies = movies;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
	

}
