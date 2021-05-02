package devops.fiap.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import devops.fiap.userservice.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	public Task findById(int id);

}