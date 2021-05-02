package devops.fiap.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import devops.fiap.userservice.entity.Movie;
import devops.fiap.userservice.entity.User;
import devops.fiap.userservice.entity.UserMovieIdentity;
import devops.fiap.userservice.entity.UserMovies;
import devops.fiap.userservice.repository.UserMoviesRepository;
import devops.fiap.userservice.vo.MessageVO;

@Service
@EnableBinding(Source.class)
public class UserMoviesService {

	@Autowired
	private UserMoviesRepository userMoviesRepository;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private Source source;

	private static final String WATCHED = "WATCHED";

	private static final String LIKED = "LIKED";

	private static final String UNLIKED = "UNLIKED";

	public List<UserMovies> getUserMovies(int userId) {
		List<UserMovies> userMovies = userMoviesRepository.findByUserMovieIdentityUserId(userId);
		return userMovies;
	}

	public UserMovies getUserMovie(UserMovieIdentity userMovieIdentity) {
		UserMovies userMovies = userMoviesRepository.findByUserMovieIdentity(userMovieIdentity);
		return userMovies;
	}

	public UserMovies setWatched(UserMovies userMovies) {
		// TODO Auto-generated method stub

		UserMovies newUserMovies = this.getUserMovie(userMovies.getUserMovieIdentity());
		if (newUserMovies == null) {
			userMovies.setWatched(true);
		} else {
			userMovies = newUserMovies;
			userMovies.setWatched(true);
		}

		MessageVO msg = new MessageVO(WATCHED, getMovie(userMovies.getUserMovieIdentity().getMovieId()));

		source.output().send(MessageBuilder.withPayload(msg).build());

		userMoviesRepository.save(userMovies);
		return userMovies;
	}

	public UserMovies toggleWatchLater(UserMovies userMovies) {
		// TODO Auto-generated method stub

		UserMovies newUserMovies = this.getUserMovie(userMovies.getUserMovieIdentity());
		if (newUserMovies == null) {
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

		if (newUserMovies == null) {
			userMovies.setLike(true);
		} else {
			userMovies = newUserMovies;
			userMovies.setLike(!userMovies.isLike());
		}

		if (userMovies.isLike()) {
			MessageVO msg = new MessageVO(LIKED, getMovie(userMovies.getUserMovieIdentity().getMovieId()));

			source.output().send(MessageBuilder.withPayload(msg).build());
		} else {

			MessageVO msg = new MessageVO(UNLIKED, getMovie(userMovies.getUserMovieIdentity().getMovieId()));

			source.output().send(MessageBuilder.withPayload(msg).build());
		}

		userMoviesRepository.save(userMovies);

		return userMovies;
	}

	private Movie getMovie(int movieId) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("%s/v1/movieservice/%s", getServiceInstanceURI("movieservice"), movieId);
		ResponseEntity<Movie> restExchange = restTemplate.exchange(uri, HttpMethod.GET, null, Movie.class, movieId);
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
