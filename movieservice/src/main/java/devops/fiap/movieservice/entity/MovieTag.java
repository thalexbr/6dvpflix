package devops.fiap.movieservice.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "tbl_movie_tag")
public class MovieTag {
	
	@EmbeddedId
	private MovieTagIdentity movieTagId;

	public MovieTag(MovieTagIdentity movieTagId) {
		super();
		this.movieTagId = movieTagId;
	}

	public MovieTagIdentity getMovieTagId() {
		return movieTagId;
	}

	public void setMovieTagId(MovieTagIdentity movieTagId) {
		this.movieTagId = movieTagId;
	}
	
	
	
}
