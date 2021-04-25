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

}
