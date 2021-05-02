package devops.fiap.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import devops.fiap.movieservice.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

	public Tag findByTag(String Tag);
	


}