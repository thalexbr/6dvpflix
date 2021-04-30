package devops.fiap.userservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import devops.fiap.userservice.entity.UserMovieIdentity;
import devops.fiap.userservice.entity.UserMovies;

public interface UserMoviesRepository extends JpaRepository<UserMovies, Integer> {
	
	public List<UserMovies> findByUserMovieIdentityUserId(int userId);
	
	public UserMovies findByUserMovieIdentity(UserMovieIdentity userMovieIdentity);


}