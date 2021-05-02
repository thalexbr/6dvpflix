package devops.fiap.movieservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import devops.fiap.movieservice.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	public Movie findById(int movieId);
	
	public List<Movie> findByGenre(String genre);
	
	@Query(value = "SELECT DISTINCT genre FROM tbl_movie", nativeQuery = true)
	public List<String> getGenres();
	
	public Movie findFirstByGenreOrderByViewsDesc(String genre);

}