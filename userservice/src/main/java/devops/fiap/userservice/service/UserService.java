package devops.fiap.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devops.fiap.userservice.entity.User;
import devops.fiap.userservice.entity.Task;
import devops.fiap.userservice.repository.UserRepository;
import devops.fiap.userservice.repository.TaskRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TaskRepository taskRepository;

	public User getUser(int userId){
		User user = userRepository.findById(userId);
		return user;
	}
	
	public User createUser(User user) {
		userRepository.save(user);
		return user;
		
	}
	
	public List<User> getAllUsers(){
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}
	
	public List<User> batchCreate(List<User> newUsers){
		
		for(User user : newUsers) {
			userRepository.save(user);
		}
		
		return newUsers;
	}

	public Task createTask(int idUser, String description) {
		Task task = new Task(idUser, description);

		taskRepository.save(task);
		return task;
		
	}

}
