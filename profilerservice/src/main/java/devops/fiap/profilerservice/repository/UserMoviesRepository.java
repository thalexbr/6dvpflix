package devops.fiap.profilerservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import devops.fiap.profilerservice.entity.UserMovieIdentity;
import devops.fiap.profilerservice.entity.UserMovies;

public interface UserMoviesRepository extends JpaRepository<UserMovies, Integer> {
	
	public List<UserMovies> findByUserMovieIdentityUserId(int userId);
	
	public UserMovies findByUserMovieIdentity(UserMovieIdentity userMovieIdentity);

}