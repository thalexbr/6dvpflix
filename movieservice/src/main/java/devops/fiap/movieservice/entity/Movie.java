package devops.fiap.movieservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tbl_movie")
public class Movie {

	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonProperty("likes")
	private double likes;
	
	@JsonProperty("views")
	private double views;
	
	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;
	
	@JsonProperty("genre")
	private String genre;


	public Movie() {
		
	}
	
	public Movie(int id, double likes, double views, String name, String description, String genre) {
		super();
		this.id = id;
		this.likes = likes;
		this.views = views;
		this.name = name;
		this.description = description;
		this.genre = genre;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLikes() {
		return likes;
	}

	public void setLikes(double likes) {
		this.likes = likes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getViews() {
		return views;
	}

	public void setViews(double views) {
		this.views = views;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
