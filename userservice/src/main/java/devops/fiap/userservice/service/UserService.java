package devops.fiap.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devops.fiap.userservice.entity.User;
import devops.fiap.userservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

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

}
