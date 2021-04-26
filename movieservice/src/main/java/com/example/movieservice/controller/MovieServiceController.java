package com.example.movieservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieservice.entity.Movie;
import com.example.movieservice.service.MovieService;


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
	
	@RequestMapping(value = "/upvote",method = RequestMethod.PUT)
	public ResponseEntity<?> upVote(@RequestBody Movie movie) {
		// Parte 1.  item 13.c
		movie = movieService.upVote(movie);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/downvote",method = RequestMethod.PUT)
	public ResponseEntity<?> downVote(@RequestBody Movie movie) {
		// Parte 1.  item 13.c
		movie = movieService.downVote(movie);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	

}