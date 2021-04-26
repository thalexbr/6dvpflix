package devops.fiap.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import devops.fiap.userservice.entity.User;
import devops.fiap.userservice.service.UserService;


@RestController
@RequestMapping(value = "/v1/userservice")
public class UserServiceController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getMovie(@PathVariable(name = "userId") int userId) {
		User user = userService.getUser(userId);
		return user;
	}
	
	/*@RequestMapping(value = "/upvote",method = RequestMethod.PUT)
	public ResponseEntity<?> upVote(@RequestBody User user) {
		// Parte 1.  item 13.c
		user = userService.upVote(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/downvote",method = RequestMethod.PUT)
	public ResponseEntity<?> downVote(@RequestBody User user) {
		// Parte 1.  item 13.c
		user = userService.downVote(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}*/
	

}