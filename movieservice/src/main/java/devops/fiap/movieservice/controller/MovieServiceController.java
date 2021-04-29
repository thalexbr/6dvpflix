package devops.fiap.movieservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import devops.fiap.movieservice.entity.Movie;
import devops.fiap.movieservice.service.MovieService;


@RestController
@RequestMapping(value = "/v1/movieservice")
public class MovieServiceController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/{movieID}", method = RequestMethod.GET)
	public Movie getMovie(@PathVariable(name = "movieID") int movieID) {
		Movie movie = movieService.getMovie(movieID);
		return movie;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Movie> getAllMovies() {
		List<Movie> movies = movieService.getAllMovies();
		return movies;
	}
	
	@RequestMapping(value = "/create/batch",method = RequestMethod.PUT)
	public ResponseEntity<?> batchCreate(@RequestBody List<Movie> movies) {

		movies = movieService.batchCreate(movies);
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/genre/{genre}", method = RequestMethod.GET)
	public List<Movie> getMovie(@PathVariable(name = "genre") String genre) {
		List<Movie> movies = movieService.getMoviesByGenre(genre);
		return movies;
	}
	
	@RequestMapping(value = "/mostviews/genre/{genre}", method = RequestMethod.GET)
	public Movie getMostViewedMoviesByGenre(@PathVariable(name = "genre") String genre) {
		Movie movies = movieService.getMostViewedMoviesByGenre(genre);
		return movies;
	}
	
	@RequestMapping(value = "/mostviews", method = RequestMethod.GET)
	public List<Movie> getMostViewedMoviesByGenre() {
		List<Movie> movies = movieService.getMostViewedMoviesByGenre();
		return movies;
	}
	
	@RequestMapping(value = "/upvote",method = RequestMethod.PUT)
	public ResponseEntity<?> upVote(@RequestBody Movie movie) {

		movie = movieService.upVote(movie);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/downvote",method = RequestMethod.PUT)
	public ResponseEntity<?> downVote(@RequestBody Movie movie) {

		movie = movieService.downVote(movie);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addview",method = RequestMethod.PUT)
	public ResponseEntity<?> addView(@RequestBody Movie movie) {

		movie = movieService.addView(movie);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.PUT)
	public ResponseEntity<?> createMovie(@RequestBody Movie movie) {

		movie = movieService.createMovie(movie);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	

}