package devops.fiap.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import devops.fiap.userservice.service.ProfilerService;
import devops.fiap.userservice.vo.ProfilerComposerVO;


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
