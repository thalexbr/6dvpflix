package devops.fiap.profilerservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import devops.fiap.profilerservice.entity.UserMovies;

public interface UserMoviesRepository extends JpaRepository<UserMovies, Integer> {
	
	public List<UserMovies> findByUserId(int userId);
	
	public UserMovies findById(int userMoviesId);

}