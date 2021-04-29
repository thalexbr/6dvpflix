package devops.fiap.userservice.vo;

public class UserMoviesVO {

	private String movieName;
	private String description;
	private String genre;
	private boolean like;
	private boolean watched;
	private boolean watch_later;
	
	public UserMoviesVO(String movieName, String description, String genre, boolean like, boolean watched,
			boolean watch_later) {
		super();
		this.movieName = movieName;
		this.description = description;
		this.genre = genre;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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
	
	