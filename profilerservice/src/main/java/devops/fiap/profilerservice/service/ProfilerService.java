package devops.fiap.profilerservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import devops.fiap.profilerservice.entity.Movie;
import devops.fiap.profilerservice.entity.User;
import devops.fiap.profilerservice.entity.UserMovies;
import devops.fiap.profilerservice.vo.ProfilerComposerVO;
import devops.fiap.profilerservice.vo.UserMoviesVO;
import devops.fiap.profilerservice.vo.UserWatchedMoviesVO;

@Service
public class ProfilerService {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private UserMoviesService userMoviesService;
	

	public ProfilerComposerVO getProfileDetails(int userId, boolean filterWatched) {
		
		List<UserMovies> userMovies = userMoviesService.getUserMovies(userId);
		List<UserMoviesVO> userMoviesVO = new ArrayList<>();
		
		
		String movieName;
		String userName = "";
		String description = "";
		String genre = "";
		
		User user = getUser(userId);
		
		userName = user.getName();
		
		for (UserMovies userMovie : userMovies) {
			if(filterWatched && !userMovie.isWatched()) {
				continue;
			}
			Movie movie = getMovie(userMovie.getUserMovieIdentity().getMovieId());
			movieName = movie.getName();
			description = movie.getDescription();
			genre = movie.getGenre();
			userMoviesVO.add(new UserMoviesVO(movieName, description, genre, userMovie.isLike(), userMovie.isWatched(), userMovie.isWatchLater()));
		}
		
		ProfilerComposerVO profilerComposerVO = new ProfilerComposerVO(userName, userMoviesVO);
		
		return profilerComposerVO;

	}
	
	private Movie getMovie(int movieId) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("%s/v1/movieservice/%s", getServiceInstanceURI("movieservice"), movieId);
		ResponseEntity<Movie> restExchange = restTemplate.exchange(uri, HttpMethod.GET, null, Movie.class,
				movieId);
		return restExchange.getBody();
	}

	private User getUser(int userId) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("%s/v1/userservice/%s", getServiceInstanceURI("userservice"), userId);
		ResponseEntity<User> restExchange = restTemplate.exchange(uri, HttpMethod.GET, null, User.class, userId);
		return restExchange.getBody();
	}

	private String getServiceInstanceURI(String serviceName) {
		List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
		if (instances.size() == 0) {
			throw new RuntimeException();
		} else {
			return instances.get(0).getUri().toString();
		}
	}

}
