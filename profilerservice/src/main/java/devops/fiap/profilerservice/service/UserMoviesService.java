package devops.fiap.profilerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import devops.fiap.profilerservice.entity.User;
import devops.fiap.profilerservice.entity.UserMovies;
import devops.fiap.profilerservice.repository.UserMoviesRepository;

@Service
public class UserMoviesService {

	@Autowired
	private UserMoviesRepository userMoviesRepository;


	public List<UserMovies> getUserMovies (int userId) {
		List<UserMovies> userMovies = userMoviesRepository.findByUserId(userId);
		return userMovies;
	}
	
	public UserMovies getUserMovie  (int userMovieId) {
		UserMovies userMovies = userMoviesRepository.findById(userMovieId);
		return userMovies;
	}


	public UserMovies toggleWatchLater(UserMovies userMovies) {
		// TODO Auto-generated method stub
		userMovies = this.getUserMovie(userMovies.getId());
		userMovies.setWatchLater(!userMovies.isWatchLater());
		userMoviesRepository.save(userMovies);
		return userMovies;
	}
	

	public UserMovies toggleLike(UserMovies userMovies) {
		// TODO Auto-generated method stub
		userMovies = this.getUserMovie(userMovies.getId());
		userMovies.setLike(!userMovies.isLike());
		
		if(userMovies.isLike()) {
			
			// Enviar evento de upvote para o broker (upvote)
		} else {
			
			// Enviar evento de upvote para o broker (downvote)
		}
		
		userMoviesRepository.save(userMovies);
		
		
		
		return userMovies;
	}
	

}
