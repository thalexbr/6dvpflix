package com.example.movieservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieservice.entity.Movie;
import com.example.movieservice.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public Movie getMovie(int movieId){
		Movie movie = movieRepository.findById(movieId);
		return movie;
	}
	
	public List<Movie> getMoviesByGenre(String genre){
		return movieRepository.findByGenre(genre);
	}
	
	public List<Movie> getMostViewedMoviesByGenre(String genre){
		return movieRepository.findByGenreOrderByViewsDesc(genre);
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
		movie.setViews(currentViews++);
		movieRepository.save(movie);
		return(movie);
	}
	
	public Movie createMovie(Movie movie) {
		
		movie.setLikes(0);
		movie.setViews(0);
		movieRepository.save(movie);	
		
		return movie;
		
	}
}
