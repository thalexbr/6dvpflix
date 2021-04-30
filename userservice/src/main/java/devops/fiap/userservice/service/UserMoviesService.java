package devops.fiap.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devops.fiap.userservice.entity.UserMovieIdentity;
import devops.fiap.userservice.entity.UserMovies;
import devops.fiap.userservice.repository.UserMoviesRepository;


@Service
public class UserMoviesService {

	@Autowired
	private UserMoviesRepository userMoviesRepository;


	public List<UserMovies> getUserMovies (int userId) {
		List<UserMovies> userMovies = userMoviesRepository.findByUserMovieIdentityUserId(userId);
		return userMovies;
	}
	
	public UserMovies getUserMovie  (UserMovieIdentity userMovieIdentity) {
		UserMovies userMovies = userMoviesRepository.findByUserMovieIdentity(userMovieIdentity);
		return userMovies;
	}

	public UserMovies setWatched(UserMovies userMovies) {
		// TODO Auto-generated method stub
		
		UserMovies newUserMovies = this.getUserMovie(userMovies.getUserMovieIdentity());
		if(newUserMovies == null) {
			userMovies.setWatched(true);
		} else {
			userMovies = newUserMovies;
			userMovies.setWatched(true);
		}
		
		//Enviar evento para contador de views
		
		userMoviesRepository.save(userMovies);
		return userMovies;
	}

	public UserMovies toggleWatchLater(UserMovies userMovies) {
		// TODO Auto-generated method stub
		
		UserMovies newUserMovies = this.getUserMovie(userMovies.getUserMovieIdentity());
		if(newUserMovies == null) {
			userMovies.setWatchLater(true);
		} else {
			userMovies = newUserMovies;
			userMovies.setWatchLater(!userMovies.isWatchLater());
		}
		
		userMoviesRepository.save(userMovies);
		return userMovies;
	}
	

	public UserMovies toggleLike(UserMovies userMovies) {
		// TODO Auto-generated method stub
		UserMovies newUserMovies = this.getUserMovie(userMovies.getUserMovieIdentity());
		
		if(newUserMovies == null) {
			userMovies.setLike(true);
		} else {
			userMovies = newUserMovies;
			userMovies.setLike(!userMovies.isLike());
		}
		
		if(userMovies.isLike()) {		
			// Enviar evento para o broker (upvote)
		} else {
			
			// Enviar evento para o broker (downvote)
		}
		
		userMoviesRepository.save(userMovies);
		
		
		
		return userMovies;
	}

}
