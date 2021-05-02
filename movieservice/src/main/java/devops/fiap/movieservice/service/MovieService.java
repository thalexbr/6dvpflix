package devops.fiap.movieservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import devops.fiap.movieservice.entity.Movie;
import devops.fiap.movieservice.repository.MovieRepository;
import devops.fiap.movieservice.vo.MessageVO;

@Service
@EnableBinding(Sink.class)
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public Movie getMovie(int movieId) {
		Movie movie = movieRepository.findById(movieId);
		return movie;
	}
	
	private static final String WATCHED = "WATCHED";
	
	private static final String LIKED = "LIKED";
	
	private static final String UNLIKED = "UNLIKED";

	public Movie createMovie(Movie movie) {

		movie.setLikes(0);
		movie.setViews(0);
		movieRepository.save(movie);

		return movie;

	}

	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	public List<Movie> batchCreate(List<Movie> movies) {
		for (Movie movie : movies) {
			movieRepository.save(movie);
		}
		return movies;
	}

	public List<Movie> getMoviesByGenre(String genre) {
		return movieRepository.findByGenre(genre);
	}

	public Movie getMostViewedMoviesByGenre(String genre) {
		return movieRepository.findFirstByGenreOrderByViewsDesc(genre);
	}

	public List<Movie> getMostViewedMoviesByGenre() {

		List<String> genres = movieRepository.getGenres();
		List<Movie> mostViewed = new ArrayList<>();

		for (String genre : genres) {
			Movie movie = movieRepository.findFirstByGenreOrderByViewsDesc(genre);
			mostViewed.add(movie);
		}

		return mostViewed;
	}

	public Movie upVote(Movie movie) {
		movie = this.getMovie(movie.getId());
		double currentLikes = movie.getLikes();
		currentLikes++;
		movie.setLikes(currentLikes);
		movieRepository.save(movie);
		return movie;
	}

	public Movie downVote(Movie movie) {
		movie = this.getMovie(movie.getId());
		double currentLikes = movie.getLikes();
		currentLikes--;
		movie.setLikes(currentLikes);
		movieRepository.save(movie);
		return movie;
	}

	public Movie addView(Movie movie) {
		movie = this.getMovie(movie.getId());
		double currentViews = movie.getViews();
		currentViews++;
		movie.setViews(currentViews);
		System.out.println("##############CURRENT VIEWS: " + currentViews + "############");
		movieRepository.save(movie);
		return (movie);
	}
	
	@StreamListener(target = Sink.INPUT)
	public void consumerUserEvent(@Payload MessageVO event) {

		switch (event.getMessageType()) {
		case WATCHED:
			addView(event.getMovie());
			break;
		case LIKED:
			upVote(event.getMovie());
			break;
		case UNLIKED:
			downVote(event.getMovie());
			break;
		default:
			System.out.println("Message Type Unknown!");
		}

	}

}
