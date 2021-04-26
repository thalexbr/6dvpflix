package com.example.movieservice.service;

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
}
