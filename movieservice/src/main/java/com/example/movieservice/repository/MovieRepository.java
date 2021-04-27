package com.example.movieservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movieservice.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	public Movie findById(int productId);
	
	public List<Movie> findByGenre(String genre);
	
	public List<Movie> findByGenreOrderByViewsDesc(String genre);

}