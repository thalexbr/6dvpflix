package devops.fiap.userservice.service;

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

}
