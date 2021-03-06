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

import devops.fiap.userservice.entity.User;
import devops.fiap.userservice.entity.Task;
import devops.fiap.userservice.entity.TaskRequest;
import devops.fiap.userservice.service.UserService;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/v1/userservice")
public class UserServiceController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable(name = "userId") int userId) {
		User user = userService.getUser(userId);
		return user;
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.PUT)
	public ResponseEntity<?> createUser(@RequestBody User user) {
		// Parte 1.  item 13.c
		user = userService.createUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@ApiOperation(value="Listar todos os usuários")
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers() {
		// Parte 1.  item 13.c
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create/batch",method = RequestMethod.PUT)
	public ResponseEntity<?> batchCreate(@RequestBody List<User> users) {
		// Parte 1.  item 13.c
		users = userService.batchCreate(users);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/task/create",method = RequestMethod.PUT)
	public ResponseEntity<?> createTask(@RequestBody TaskRequest taskRequest) {
		// Parte 1.  item 13.c
		Task task = userService.createTask(taskRequest.getIdUser(), taskRequest.getDescription());

		return new ResponseEntity<>(task, HttpStatus.OK);
	}
}