package devops.fiap.movieservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieTagIdentity implements Serializable{
	
    @NotNull
    @Column(name = "movie_id")
    @JsonProperty("movie_id")
	private int movieId;
	
    @NotNull
    @Column(name = "tag_id")
	@JsonProperty("tag_id")
	private int tagId;

	public MovieTagIdentity(@NotNull int movieId, @NotNull int tagId) {
		super();
		this.movieId = movieId;
		this.tagId = tagId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public MovieTagIdentity() {

	}
    
    

}
