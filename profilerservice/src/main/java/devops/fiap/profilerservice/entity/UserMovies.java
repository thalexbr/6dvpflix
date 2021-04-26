package devops.fiap.profilerservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tbl_user_movies")
public class UserMovies {
	
	@Id
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("user_id")
	@Column(name = "user_id")
	private int userId;
	
	@JsonProperty("movie_id")
	@Column(name = "movie_id")
	private int movieId;
	
	@JsonProperty("liked")
	@Column(name = "liked")
	private boolean like;
	
	@JsonProperty("watched")
	private boolean watched;
	
	@JsonProperty("watch_later")
	@Column(name = "watch_later")
	private boolean watchLater;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	public boolean isLike() {
		return like;
	}
	
	public void setLike(boolean like) {
		this.like = like;
	}
	
	public boolean isWatched() {
		return watched;
	}
	
	public void setWatched(boolean watched) {
		this.watched = watched;
	}

	public boolean isWatchLater() {
		return watchLater;
	}

	public void setWatchLater(boolean watchLater) {
		this.watchLater = watchLater;
	}

}
