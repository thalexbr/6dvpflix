package devops.fiap.movieservice.vo;

import devops.fiap.movieservice.entity.Movie;

public class MessageVO {
	
	private String messageType;
	
	private Movie movie;

	public MessageVO(String messageType, Movie movie) {
		super();
		this.messageType = messageType;
		this.movie = movie;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	

}
