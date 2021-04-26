package devops.fiap.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import devops.fiap.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findById(int productId);

}