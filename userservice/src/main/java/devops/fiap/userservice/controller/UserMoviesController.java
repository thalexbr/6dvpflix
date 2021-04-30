package devops.fiap.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import devops.fiap.userservice.entity.UserMovies;
import devops.fiap.userservice.service.UserMoviesService;



@RestController
@RequestMapping(value = "/v1/usermoviesservice")
public class UserMoviesController {

	@Autowired
	private UserMoviesService userMoviesService;

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public List<UserMovies> getUserMovies(@PathVariable(name = "userId") int userId) {
		
		return userMoviesService.getUserMovies(userId);
	}
	
	@RequestMapping(value = "/togglewatchlater",method = RequestMethod.PUT)
	public ResponseEntity<?> toggleWatchLater(@RequestBody UserMovies userMovies) {
		// Parte 1.  item 13.c
		
		userMovies = userMoviesService.toggleWatchLater(userMovies);
		return new ResponseEntity<>(userMovies, HttpStatus.OK);
	}

	@RequestMapping(value = "/togglelike",method = RequestMethod.PUT)
	public ResponseEntity<?> toggleLike(@RequestBody UserMovies userMovies) {
		// Parte 1.  item 13.c
		
		userMovies = userMoviesService.toggleLike(userMovies);
		return new ResponseEntity<>(userMovies, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/setwatched",method = RequestMethod.PUT)
	public ResponseEntity<?> setWatched(@RequestBody UserMovies userMovies) {
		// Parte 1.  item 13.c
		
		userMovies = userMoviesService.setWatched(userMovies);
		return new ResponseEntity<>(userMovies, HttpStatus.OK);
	}
	
}
