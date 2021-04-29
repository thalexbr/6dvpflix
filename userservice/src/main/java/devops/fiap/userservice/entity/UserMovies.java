package devops.fiap.userservice.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tbl_user_movies")
public class UserMovies {
	
	@EmbeddedId
	private UserMovieIdentity userMovieIdentity;
	
	@JsonProperty("liked")
	@Column(name = "liked")
	private boolean like;
	
	@JsonProperty("watched")
	private boolean watched;
	
	@JsonProperty("watch_later")
	@Column(name = "watch_later")
	private boolean watchLater;
	
	
	
	public UserMovieIdentity getUserMovieIdentity() {
		return userMovieIdentity;
	}

	public void setUserMovieIdentity(UserMovieIdentity userMovieIdentity) {
		this.userMovieIdentity = userMovieIdentity;
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
