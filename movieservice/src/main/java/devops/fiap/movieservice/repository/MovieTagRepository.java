package devops.fiap.movieservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import devops.fiap.movieservice.entity.MovieTag;

public interface MovieTagRepository extends JpaRepository<MovieTag, Integer> {

	public List<MovieTag> findByMovieTagIdMovieId(int movieId);

	public List<MovieTag> findByMovieTagIdTagId(int tagId);

}