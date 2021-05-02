package devops.fiap.movieservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devops.fiap.movieservice.entity.Movie;
import devops.fiap.movieservice.entity.MovieTag;
import devops.fiap.movieservice.entity.Tag;
import devops.fiap.movieservice.repository.MovieRepository;
import devops.fiap.movieservice.repository.MovieTagRepository;
import devops.fiap.movieservice.repository.TagRepository;
import devops.fiap.movieservice.vo.MovieTagVO;

@Service
public class MovieTagService {
	
	@Autowired
	MovieTagRepository movieTagRepository;
	
	@Autowired
	TagRepository tagRepository;
	
	@Autowired
	MovieRepository movieRepository;

	public MovieTagVO getMoviesByTag(String tagName) {
		
		Tag tag = tagRepository.findByTag(tagName);
		List<Movie> movies = new ArrayList<>();
		
		List<MovieTag> movieTags = movieTagRepository.findByMovieTagIdentityTagId(tag.getTagId());
		
		for(MovieTag movieTag : movieTags) {
			
			movies.add(movieRepository.findById(movieTag.getMovieTagId().getMovieId()));
			
		}
		
		MovieTagVO movieTagVO = new MovieTagVO(tagName, movies); 
		
		return movieTagVO;

	}

	public MovieTag addMovieTag(MovieTag movieTag) {
		// TODO Auto-generated method stub
		
		return movieTagRepository.save(movieTag);
		
	}
	
	public Tag createTag(Tag tag) {
		
		return tagRepository.save(tag);
	}
	
}
