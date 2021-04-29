package devops.fiap.userservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class UserMovieIdentity implements Serializable {
    @NotNull
    @Column(name = "user_id")
    @JsonProperty("user_id")
    private int userId;

    @NotNull
    @Column(name = "movie_id")
    @JsonProperty("movie_id")
    private int movieId;

    public UserMovieIdentity() {

    }

    public UserMovieIdentity(int userId, int companyId) {
        this.userId = userId;
        this.movieId = companyId;
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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserMovieIdentity that = (UserMovieIdentity) o;

        if (!(userId==that.getUserId())) return false;
        return (movieId==that.getMovieId());
    }

}
