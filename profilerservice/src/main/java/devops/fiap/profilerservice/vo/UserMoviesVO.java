package devops.fiap.profilerservice.vo;

public class UserMoviesVO {

	private String movieName;
	private boolean like;
	private boolean watched;
	private boolean watch_later;
	
	public UserMoviesVO(String movieName, boolean like, boolean watched, boolean watch_later) {
		super();
		this.movieName = movieName;
		this.like = like;
		this.watched = watched;
		this.watch_later = watch_later;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
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

	public boolean isWatch_later() {
		return watch_later;
	}

	public void setWatch_later(boolean watch_later) {
		this.watch_later = watch_later;
	}
	
	
	
}
