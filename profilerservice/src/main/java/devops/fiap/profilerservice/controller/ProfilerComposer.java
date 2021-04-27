package devops.fiap.profilerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import devops.fiap.profilerservice.entity.Movie;
import devops.fiap.profilerservice.entity.UserMovies;
import devops.fiap.profilerservice.service.ProfilerService;
import devops.fiap.profilerservice.vo.ProfilerComposerVO;
import devops.fiap.profilerservice.vo.UserMoviesVO;

@RestController
@RequestMapping(value = "/v1/profilerservice")
public class ProfilerComposer {
	
	private static final boolean ALL_MOVIES = false;
	private static final boolean WATCHED = true;
	

	@Autowired
	private ProfilerService profilerService;

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ProfilerComposerVO getUserMovies(@PathVariable(name = "userId") int userId) {
		return profilerService.getProfileDetails(userId, ALL_MOVIES);
	}
	
	@RequestMapping(value = "/watched/{userId}", method = RequestMethod.GET)
	public ProfilerComposerVO getUserMoviesWatched(@PathVariable(name = "userId") int userId) {
		return profilerService.getProfileDetails(userId, WATCHED);
	}
	


}
