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

import devops.fiap.userservice.entity.Movie;
import devops.fiap.userservice.entity.UserMovies;
import devops.fiap.userservice.service.ProfilerService;
import devops.fiap.userservice.vo.ProfilerComposerVO;
import devops.fiap.userservice.vo.UserMoviesVO;

@RestController
@RequestMapping(value = "/v1/userservice")
public class ProfilerComposer {
	
	private static final boolean ALL_MOVIES = false;
	private static final boolean WATCHED = true;
	

	@Autowired
	private ProfilerService profileService;

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ProfilerComposerVO getUserMovies(@PathVariable(name = "userId") int userId) {
		return profileService.getProfileDetails(userId, ALL_MOVIES);
	}
	
	@RequestMapping(value = "/watched/{userId}", method = RequestMethod.GET)
	public ProfilerComposerVO getUserMoviesWatched(@PathVariable(name = "userId") int userId) {
		return profileService.getProfileDetails(userId, WATCHED);
	}
	


}
